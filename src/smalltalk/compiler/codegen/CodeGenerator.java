package smalltalk.compiler.codegen;

import org.antlr.symtab.Scope;
import org.antlr.symtab.StringTable;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;

import smalltalk.compiler.parser.SmalltalkBaseVisitor;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.Compiler;
import smalltalk.compiler.semantics.STBlock;
import smalltalk.misc.Utils;


import smalltalk.vm.Bytecode;
import smalltalk.vm.primitive.STCompiledBlock;
import smalltalk.vm.primitive.STMetaClassObject;
import smalltalk.vm.primitive.STString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Fill STBlock, STMethod objects in Symbol table with bytecode,
 * {@link smalltalk.vm.primitive.STCompiledBlock}.
 */
public class CodeGenerator extends SmalltalkBaseVisitor<Code> {
	public Scope currentScope;

	/** With which compiler are we generating code? */
	public final smalltalk.compiler.Compiler compiler;

	public final Map<Scope,StringTable> blockToStrings = new HashMap<>();

	public CodeGenerator(Compiler compiler) {
        this.compiler = compiler;
        blockToStrings.put(compiler.symtab.GLOBALS, new StringTable());
	}

	/** This and defaultResult() critical to getting code to bubble up the
	 *  visitor call stack when we don't implement every method.
	 */
	@Override
	protected Code aggregateResult(Code aggregate, Code nextResult) {
        if ( aggregate!=Code.None ) {
            if ( nextResult!=Code.None ) {
                return aggregate.join(nextResult);
            }
            return aggregate;
        }
        else {
            return nextResult;
        }
	}

	@Override
	protected Code defaultResult() {
		return Code.None;
	}

	@Override
	public Code visitFile(@NotNull SmalltalkParser.FileContext ctx) {
		pushScope(compiler.symtab.GLOBALS);
        visitChildren(ctx);
        return Code.None;
	}

	@Override
	public Code visitClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
		pushScope(ctx.scope);
		Code code = visitChildren(ctx);
		popScope();
		return Code.None;
	}

    @Override
    public Code visitMain(@NotNull SmalltalkParser.MainContext ctx) {
        if(ctx.body() == null || ctx.body().getChildCount() == 0)
            return Code.None;
        pushScope(ctx.classScope);
        pushScope(ctx.scope);
        Code  code = visit(ctx.body());
        if(compiler.genDbg)
            code = Code.join(code,dbgAtEndMain(ctx.stop));
        if(ctx.body() instanceof SmalltalkParser.FullBodyContext)
            code = code.join(Compiler.pop());         //pop (only if full body)
        code = code.join(Code.of(Bytecode.SELF));     //self
        code = code.join(Compiler.method_return());   //return
        ctx.scope.compiledBlock = getCompiledBlock(ctx.scope, code, false);
        popScope();
        popScope();
        		System.out.println(Bytecode.disassemble(ctx.scope.compiledBlock, 0));

        return Code.None;
    }

    @Override
    public Code visitFullBody(@NotNull SmalltalkParser.FullBodyContext ctx) {
        Code code  = new Code();
        int n = ctx.stat().size();
        for(int i = 0; i< n-1; i++){
            SmalltalkParser.StatContext ectx = ctx.stat().get(i);
            code  = Code.join(code, visit(ectx),compiler.pop());
        }
        SmalltalkParser.StatContext lastExpr = ctx.stat().get(n-1);
        Code bodyResultCode = visit(lastExpr);
        return code.join(bodyResultCode);
    }

    @Override
    public Code visitEmptyBody(@NotNull SmalltalkParser.EmptyBodyContext ctx) {
        Code code = visitChildren(ctx);
        return code;
    }

    @Override
    public Code visitNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx) {
        pushScope(ctx.scope);
        Code code = visitChildren(ctx);
        popScope();
        return code;

    }

    @Override
    public Code visitOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx) {
        pushScope(ctx.scope);
        Code code  = visitChildren(ctx);
        popScope();
        return code;
    }

    @Override
    public Code visitKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx) {
        pushScope(ctx.scope);
        Code code  = visitChildren(ctx);
        popScope();
        return code;

    }

    @Override
    public Code visitKeywordSend(@NotNull SmalltalkParser.KeywordSendContext ctx) {
        //simply a binary expression
        if(ctx.getChildCount() == 1)
            return visit(ctx.binaryExpression(0));
        //receiver binary
        Code receiver = visit(ctx.recv);
        //keywords + args
        List<TerminalNode> keywords = ctx.KEYWORD();
        List<SmalltalkParser.BinaryExpressionContext> binaries = ctx.binaryExpression();

        StringBuffer keyword = new StringBuffer();
        Code args = new Code();

        for(int i = 0; i < keywords.size(); i++){
            keyword.append(keywords.get(i).getText());
            args.join(visit(binaries.get(i + 1))); //binaries[0] is dedicated to receiver
        }

        Code send = send(ctx.args.size(), keyword.toString());
        Code code = receiver.join(args).join(send);
        return code;

    }

    @Override
    public Code visitSuperKeywordSend(@NotNull SmalltalkParser.SuperKeywordSendContext ctx) {
        Code self = Compiler.push_predefined("self");
        //keywords + args
        List<TerminalNode> keywords = ctx.KEYWORD();
        List<SmalltalkParser.BinaryExpressionContext> binaries = ctx.binaryExpression();

        StringBuffer keyword = new StringBuffer();
        Code args = new Code();

        for(int i = 0; i < keywords.size(); i++){
            keyword.append(keywords.get(i).getText());
            args.join(visit(binaries.get(i + 1))); //binaries[0] is dedicated to receiver
        }


        Code send_super = sendSuper(keyword.toString());
        Code code = self.join(args).join(send_super);
        return code;
    }

    private Code send(int numOfArgs, String keyword) {
      //  blockToStrings.get(currentScope).add(keyword);
        int index = getLiteralIndex(keyword);
        return Code.of(Bytecode.SEND).join(Utils.shortToBytes(numOfArgs)).join(Utils.shortToBytes(index));
    }
    private Code sendSuper( String keyword) {
        //blockToStrings.get(currentScope).add(keyword);
        int index = getLiteralIndex(keyword);
        return Code.of(Bytecode.SEND_SUPER).join(Utils.shortToBytes(0)).join(Utils.shortToBytes(index));
    }

    @Override
    public Code visitUnaryMsgSend(@NotNull SmalltalkParser.UnaryMsgSendContext ctx) {
        Code unary = visit(ctx.unaryExpression());
        Code send = send(0,ctx.ID().getText());
        return unary.join(send);
    }

    @Override
    public Code visitUnarySuperMsgSend(@NotNull SmalltalkParser.UnarySuperMsgSendContext ctx) {
        return Compiler.push_predefined("self").join(sendSuper(ctx.ID().getText()));
    }

    @Override
	public Code visitPrimitiveMethodBlock(@NotNull SmalltalkParser.PrimitiveMethodBlockContext ctx) {
        SmalltalkParser.MethodContext methodNode = (SmalltalkParser.MethodContext)ctx.getParent();
        Code code = visitChildren(ctx);
        methodNode.scope.compiledBlock = getCompiledBlock(methodNode.scope, code, methodNode.scope.isClassMethod);

        return code;
    }

	@Override
	public Code visitSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
		SmalltalkParser.MethodContext methodNode = (SmalltalkParser.MethodContext)ctx.getParent();
//		System.out.println("Gen code for " + methodNode.scope.getName()+" "+getProgramSourceForSubtree(ctx));
		Code code = new Code();
        if(ctx.body() instanceof SmalltalkParser.EmptyBodyContext)
             code = visitEmptyBody((SmalltalkParser.EmptyBodyContext)ctx.body());
        else
            code = visit(ctx.body());
        if ( compiler.genDbg ) { // put dbg in front of push_self
            code = Code.join(code, dbgAtEndBlock(ctx.stop));
        }

        if ( ctx.body() instanceof SmalltalkParser.FullBodyContext ) {
			// pop final value unless block is empty
			code = code.join(Compiler.pop()); // visitFullBody() doesn't have last pop; we toss here but use with block_return in visitBlock
		}

        // always add ^self in case no return statement
        code = code.join(Compiler.push_self());
		code = code.join(Compiler.method_return());
		methodNode.scope.compiledBlock = getCompiledBlock(methodNode.scope, code, methodNode.scope.isClassMethod);
//		System.out.println(Bytecode.disassemble(methodNode.scope.compiledMethod, 0));
		return code;
	}

    @Override
    public Code visitBlock(@NotNull SmalltalkParser.BlockContext ctx) {
        pushScope(ctx.scope);
        Code code = Compiler.block(ctx.scope);
        Code blk = visitChildren(ctx);
        if (blk.size() == 0)
            blk = Compiler.push_nil();
        blk = blk.join(Compiler.block_return());
        ctx.scope.compiledBlock = getCompiledBlock(ctx.scope, blk, false);
//		System.out.println(Bytecode.disassemble(methodNode.scope.compiledMethod, 0));
        popScope();
        return code;
    }


    @Override
	public Code visitAssign(@NotNull SmalltalkParser.AssignContext ctx) {
		Code push = visit(ctx.messageExpression());
		Code store = Compiler.store(ctx.lvalue().ID().getText(), currentScope);
		Code code = push.join(store);
		if ( compiler.genDbg ) {
			code = dbg(ctx.start).join(code);
		}
		return code;
	}

    @Override
    public Code visitId(@NotNull SmalltalkParser.IdContext ctx) {
        Code code = Compiler.push(ctx.ID().getText(), currentScope, this);
        return code;
    }

    @Override
    public Code visitNumberLiteral(@NotNull SmalltalkParser.NumberLiteralContext ctx) {
        Code code = Compiler.push_literal(ctx, currentScope, this);
        return code;
    }

    @Override
    public Code visitCharLiteral(@NotNull SmalltalkParser.CharLiteralContext ctx) {
        Code code = Compiler.push_literal(ctx, currentScope,this);
        return code;
    }

    @Override
    public Code visitStringLiteral(@NotNull SmalltalkParser.StringLiteralContext ctx) {
        Code code = Compiler.push_literal(ctx, currentScope, this);
        return code;
    }

    @Override
    public Code visitPredefinedLiteral(@NotNull SmalltalkParser.PredefinedLiteralContext ctx) {
        Code code = Compiler.push_literal(ctx,currentScope,this);
        return code;
    }

    @Override
    public Code visitBinaryExpression(@NotNull SmalltalkParser.BinaryExpressionContext ctx) {
        //unary expression, no bop/args
        if(ctx.getChildCount() == 1)
            return visit(ctx.unaryExpression(0));
        //binary expression
        //first unary as receiver
        Code receiver = visit(ctx.unaryExpression(0));
        //append all arg+send.
        List<SmalltalkParser.BopContext> ops = ctx.bop();
        List<SmalltalkParser.UnaryExpressionContext> args = ctx.unaryExpression();
        for(int i = 0; i < ops.size(); i++){
            Code arg = visit(args.get(i+1));//args[0] dedicated to receiver
            Code send = sendBop(ops.get(i));
            receiver.join(arg).join(send);
        }
        return receiver;
    }

    private Code sendBop(SmalltalkParser.BopContext ctx) {
        String keyword;
        if(ctx.opchar().size() == 0) // "-" only
            keyword = "-";
        else if(ctx.opchar().size() == 1)            //single char
            keyword = ctx.opchar(0).getText();
        else                                    //double chars
            keyword = ctx.opchar(0).getText() + ctx.opchar(1).getText();
        return send(1, keyword);                //numOfArg == 1
    }

    @Override
    public Code visitArray(@NotNull SmalltalkParser.ArrayContext ctx) {
        Code elements = visitChildren(ctx);
        Code array = Code.of(Bytecode.PUSH_ARRAY).join(Utils.toLiteral(ctx.messageExpression().size()));
        return elements.join(array);
    }

    @Override
	public Code visitReturn(@NotNull SmalltalkParser.ReturnContext ctx) {
		Code e = visit(ctx.messageExpression());
		if ( compiler.genDbg ) {
			e = Code.join(e, dbg(ctx.start)); // put dbg after expression as that is when it executes
		}
		Code code = e.join(Compiler.method_return());
		return code;
	}

	public void pushScope(Scope scope) {
        currentScope = scope;
        blockToStrings.put(currentScope,new StringTable());
	}

	public void popScope() {

		currentScope = currentScope.getEnclosingScope();
	}

    private STCompiledBlock getCompiledBlock(STBlock scope, Code code, Boolean isClassMethod) {
        STCompiledBlock compiledBlock = new STCompiledBlock(scope, isClassMethod);
        compiledBlock.bytecode = code.bytes();
        compiledBlock.literals = blockToStrings.get(scope).toArray();
        compiledBlock.literalsAsSTStrings = new STString[compiledBlock.literals.length];
        literalAsString();
        return compiledBlock;
    }

    private void literalAsString() {

    }

    public int getLiteralIndex(String text) {
/*        StringTable strings = blockToStrings.get(currentScope);
        String[] list = strings.toArray();
        for(int i = 0; i< list.length; i++){
            if(list[i].equals(text))
                return i;
        }*/
        return blockToStrings.get(currentScope).add(text);
    }

	public Code dbgAtEndMain(Token t) {
		int charPos = t.getCharPositionInLine() + t.getText().length();
		return dbg(t.getLine(), charPos);
	}

	public Code dbgAtEndBlock(Token t) {
		int charPos = t.getCharPositionInLine() + t.getText().length();
		charPos -= 1; // point at ']'
		return dbg(t.getLine(), charPos);
	}

	public Code dbg(Token t) {
		return dbg(t.getLine(), t.getCharPositionInLine());
	}

	public Code dbg(int line, int charPos) {

        return Compiler.dbg(getLiteralIndex(compiler.getFileName()), line, charPos);
	}
}

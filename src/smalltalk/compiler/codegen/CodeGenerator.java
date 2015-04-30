package smalltalk.compiler.codegen;

import org.antlr.symtab.Scope;
import org.antlr.symtab.StringTable;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import smalltalk.compiler.*;
import smalltalk.compiler.Compiler;
import smalltalk.compiler.codegen.Code;
import smalltalk.compiler.parser.SmalltalkBaseVisitor;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.semantics.STMethod;
import smalltalk.vm.Bytecode;
import smalltalk.vm.primitive.STCompiledBlock;

import java.util.HashMap;
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
		return code;
	}

    @Override
    public Code visitInstanceVars(@NotNull SmalltalkParser.InstanceVarsContext ctx) {
        return Code.None;
    }

    @Override
    public Code visitClassMethod(@NotNull SmalltalkParser.ClassMethodContext ctx) {
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
        ctx.scope.compiledBlock = getCompiledBlock(ctx.scope, code);
        popScope();
        popScope();
        return super.visitMain(ctx);
    }

    @Override
    public Code visitFullBody(@NotNull SmalltalkParser.FullBodyContext ctx) {
        Code code  = Code.None;
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
        Code code = visitSmalltalkMethodBlock((SmalltalkParser.SmalltalkMethodBlockContext) ctx.methodBlock());
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
    public Code visitSuperKeywordSend(@NotNull SmalltalkParser.SuperKeywordSendContext ctx) {
        if(ctx.getChildCount() == 1)
            return visit(ctx.binaryExpression(0));
        Code receiver = visit(ctx.binaryExpression(0));
       // Code code = sendKeywordMsg(ctx.recv, receiver, ctx.args);
       // return code;
        return Code.None;
    }

    @Override
	public Code visitPrimitiveMethodBlock(@NotNull SmalltalkParser.PrimitiveMethodBlockContext ctx) {
        visitChildren(ctx);
        // SmalltalkParser.MethodContext methodCxt = ;
        //methodCxt.scope.compiledBlock = getCompiledPrimitive(methodCxt.Scope, code);
        return Code.None;

    }

	@Override
	public Code visitSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
		SmalltalkParser.MethodContext methodNode = (SmalltalkParser.MethodContext)ctx.getParent();
//		System.out.println("Gen code for " + methodNode.scope.getName()+" "+getProgramSourceForSubtree(ctx));
		Code code = Code.None;
        if(ctx.body() instanceof SmalltalkParser.EmptyBodyContext)
             code = visitEmptyBody((SmalltalkParser.EmptyBodyContext)ctx.body());
     //   code = visitChildren(ctx);
		// always add ^self in case no return statement
		if ( compiler.genDbg ) { // put dbg in front of push_self
			code = Code.join(code, dbgAtEndBlock(ctx.stop));
		}
		if ( ctx.body() instanceof SmalltalkParser.FullBodyContext ) {
			// pop final value unless block is empty
			code = code.join(Compiler.pop()); // visitFullBody() doesn't have last pop; we toss here but use with block_return in visitBlock
		}
		code = code.join(Compiler.push_self());
		code = code.join(Compiler.method_return());
		methodNode.scope.compiledBlock = getCompiledBlock(methodNode.scope, code);
//		System.out.println(Bytecode.disassemble(methodNode.scope.compiledMethod, 0));
		return code;
	}

    private STCompiledBlock getCompiledBlock(STMethod scope, Code code) {
        STCompiledBlock compiledBlock = new STCompiledBlock(scope);
        compiledBlock.bytecode = code.bytes();
        return compiledBlock;
    }

    @Override
	public Code visitAssign(@NotNull SmalltalkParser.AssignContext ctx) {
		Code e = visit(ctx.messageExpression());
		Code store = store(ctx.lvalue().ID().getText());
		Code code = e.join(store);
		if ( compiler.genDbg ) {
			code = dbg(ctx.start).join(code);
		}
		return code;
	}

    private Code store(String text) {
        return Code.None;
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
	}

	public void popScope() {
//		if ( currentScope.getEnclosingScope()!=null ) {
//			System.out.println("popping from " + currentScope.getScopeName() + " to " + currentScope.getEnclosingScope().getScopeName());
//		}
//		else {
//			System.out.println("popping from " + currentScope.getScopeName() + " to null");
//		}
		currentScope = currentScope.getEnclosingScope();
	}

	public int getLiteralIndex(String s) {
        return 0;
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

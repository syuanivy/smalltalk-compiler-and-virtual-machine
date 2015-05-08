package smalltalk.compiler;

import org.antlr.symtab.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import smalltalk.compiler.codegen.Code;
import smalltalk.compiler.codegen.CodeGenerator;
import smalltalk.compiler.parser.SmalltalkLexer;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.semantics.*;
import smalltalk.misc.Utils;
import smalltalk.vm.Bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compiler {
	public final STSymbolTable symtab;
	public final List<String> errors = new ArrayList<>();
	protected SmalltalkParser parser;
	protected CommonTokenStream tokens;
	protected SmalltalkParser.FileContext fileTree;
	protected String fileName;
	public boolean genDbg; // generate dbg file,line instructions

	public Compiler() {
        symtab = new STSymbolTable();
        fileName = "<unknown>";
    }

	public Compiler(STSymbolTable symtab) {
        this.symtab = symtab;
        fileName = "<string>";
	}

	public STSymbolTable compile(ANTLRInputStream input){
        if (input.name != null) {
            String[] strings = input.name.split("/");
            fileName = strings[strings.length - 1];
        }
		// parse class(es)
        ParserRuleContext tree = parseClasses(input);
        // define symbols
        defSymbols(tree);
        // resolve symbols
        resolveSymbols(tree);
        // gen codes
        codeGenerate(tree);

		return symtab;
	}

    public ParserRuleContext parseClasses(@NotNull ANTLRInputStream inputStream){
        SmalltalkLexer l = new SmalltalkLexer(inputStream);
        this.tokens = new CommonTokenStream(l);

        this.parser = new SmalltalkParser(tokens);
        this.fileTree = parser.file();

        return fileTree;
    }
    public void defSymbols(@NotNull ParserRuleContext ctx){
        DefineSymbols def = new DefineSymbols(this);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(def, ctx);

    }
    public void resolveSymbols(@NotNull ParserRuleContext ctx){
        ResolveSymbols res = new ResolveSymbols(this);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(res, ctx);
    }
    public void codeGenerate(@NotNull ParserRuleContext ctx){
        CodeGenerator gen = new CodeGenerator(this);
        gen.visit(ctx);
    }


    // Convenience methods for code gen
	public static Code push_nil() 				{ return Code.of(Bytecode.NIL); }
	public static Code push_char(int c)			{ return Code.of(Bytecode.PUSH_CHAR).join(Utils.shortToBytes(c)); }
	public static Code push_int(int v) 			{ return Code.of(Bytecode.PUSH_INT).join(Utils.intToBytes(v)); }
    public static Code method_return() {
        return Code.of(Bytecode.RETURN);
    }
    public static Code block_return(){
        return Code.of(Bytecode.BLOCK_RETURN);
    }
    public static Code push_self() {
        return Code.of(Bytecode.SELF);
    }
    public static Code block(STBlock blk){
        return Code.of(Bytecode.BLOCK).join(Utils.shortToBytes(blk.index));
    }
    public static Code pop() { return Code.of(Bytecode.POP);}
    public static Code store(String text, Scope current) {
        Symbol s = current.resolve(text);
        Code code = new Code();
        if(s instanceof FieldSymbol){
            int index = ((STClass)s.getScope()).getFieldIndex(text);
            code = Code.of(Bytecode.STORE_FIELD).join(Utils.shortToBytes(index));
        }
        else if(s instanceof VariableSymbol){
            int index = ((STBlock)s.getScope()).getLocalIndex(text);
            int delta = ((STBlock)current).getRelativeScopeCount(s.getScope().getName());
            code = Code.of(Bytecode.STORE_LOCAL).join(Utils.shortToBytes(delta).join(Utils.shortToBytes(index)));
        }

        return code;
    }

    public static Code push(String text, Scope current, CodeGenerator gen){
        Symbol s = current.resolve(text);
        Code code = Code.None;
        if(s == null){
           // gen.blockToStrings.get(current).add(text);
            code = Code.of(Bytecode.PUSH_GLOBAL).join(Utils.toLiteral(gen.getLiteralIndex(text)));
        }
        else if(s instanceof  FieldSymbol){
            int index = ((STClass)s.getScope()).getFieldIndex(text);
            code = Code.of(Bytecode.PUSH_FIELD).join(Utils.toLiteral(index));
        }
        else if(s instanceof ParameterSymbol){
            int index = ((STBlock)s.getScope()).getLocalIndex(text);
            int delta = ((STBlock)current).getRelativeScopeCount(s.getScope().getName());
            code = Code.of(Bytecode.PUSH_LOCAL).join(Utils.toLiteral(delta).join(Utils.toLiteral(index)));
        }
        else if (s instanceof VariableSymbol){
            int index = ((STBlock)s.getScope()).getLocalIndex(text);
            int delta = ((STBlock)current).getRelativeScopeCount(s.getScope().getName());
            code = Code.of(Bytecode.PUSH_LOCAL).join(Utils.toLiteral(delta).join(Utils.toLiteral(index)));
        }
        else if(s instanceof STClass){
           // gen.blockToStrings.get(current).add(s.getName());
            code = Code.of(Bytecode.PUSH_GLOBAL).join(Utils.toLiteral(gen.getLiteralIndex(text)));
        }
        return code;
    }

    public static Code push_literal(ParserRuleContext ctx, Scope current, CodeGenerator gen) {
        Code code = Code.None;
        if(ctx instanceof SmalltalkParser.PredefinedLiteralContext){
            SmalltalkParser.PredefinedContext p = ((SmalltalkParser.PredefinedLiteralContext) ctx).predefined();
            code = push_predefined(p.getText());
        }
        else if(ctx instanceof SmalltalkParser.NumberLiteralContext){
            String digits = ((SmalltalkParser.NumberLiteralContext) ctx).NUMBER().getText();
            float f;
            int i;
            if(digits.contains(".")){
                f = Float.parseFloat(digits);
                code = Code.of(Bytecode.PUSH_FLOAT).join(Utils.floatToBytes(f));
            }
            else{
                i = Integer.parseInt(digits);
                code = Code.of(Bytecode.PUSH_INT).join(Utils.intToBytes(i));
            }

        }
        else if(ctx instanceof SmalltalkParser.StringLiteralContext){
            String text = ((SmalltalkParser.StringLiteralContext) ctx).STRING().getText();

            code = push_string(text, current, gen);
        }

        else if(ctx instanceof SmalltalkParser.CharLiteralContext){
            String c = ((SmalltalkParser.CharLiteralContext)ctx).CHAR().getText();
            int character = (int) c.charAt(1);
            System.out.println(c);
            System.out.println(c.substring(1));
            code = Code.of(Bytecode.PUSH_CHAR).join(Utils.toLiteral(character));
        }

        return code;
    }
    public static Code push_string(String text, Scope current, CodeGenerator gen){
        String s;
        if(isString(text))
            s = text.substring(1,text.length()-1);
        else
            s = text;
       // gen.blockToStrings.get(current).add(s);
        Code code = Code.of(Bytecode.PUSH_LITERAL).join(Utils.toLiteral(gen.getLiteralIndex(s)));
        return code;
    }

    public static Code push_predefined(String p) {
        Code code;
        if(p.equals("self"))
            code = Code.of(Bytecode.SELF);
        else if(p.equals("super"))
            code = Code.of(Bytecode.SEND_SUPER);
        else if(p.equals("nil"))
            code = Code.of(Bytecode.NIL);
        else if(p.equals("true"))
            code = Code.of(Bytecode.TRUE);
        else if(p.equals("false"))
            code = Code.of(Bytecode.FALSE);
        else
            return null;
        return code;
    }

    private static boolean isString(String text) {
        return text.charAt(0) == '\'' && text.charAt(text.length() - 1) == '\'';

    }
    // Error support
	public void error(String msg) {
		errors.add(msg);
	}
	public void error(String msg, Exception e) {
		errors.add(msg+"\n"+ Arrays.toString(e.getStackTrace()));
	}


    public String getFileName() {
        return fileName;
    }

//    public static Code dbg(int literalIndex, int line, int charPos) {
//        return Code.of(Bytecode.DBG).join(Utils.shortToBytes(literalIndex)).join(Utils.intToBytes(Bytecode.combineLineCharPos(line, charPos)));
//    }
    public static Code dbg(int index, int line, int charPos) 	{
        //return Code.None;
        return Code.of(Bytecode.DBG).join(Utils.toLiteral(index)).join(Utils.intToBytes(Bytecode.combineLineCharPos(line, charPos)));
     }
}

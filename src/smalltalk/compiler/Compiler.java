package smalltalk.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import smalltalk.compiler.codegen.Code;
import smalltalk.compiler.codegen.CodeGenerator;
import smalltalk.compiler.parser.SmalltalkLexer;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.semantics.DefineSymbols;
import smalltalk.compiler.semantics.ResolveSymbols;
import smalltalk.compiler.semantics.STSymbolTable;
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

	public Compiler() { symtab = new STSymbolTable();}

	public Compiler(STSymbolTable symtab) {
		this.symtab = symtab;
	}

	public STSymbolTable compile(ANTLRInputStream input){
        fileName = input.name;
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
    public static Code push_self() {
        return Code.of(Bytecode.SELF);
    }
    public static Code pop() { return Code.of(Bytecode.POP);}




	// Error support
	public void error(String msg) {
		errors.add(msg);
	}
	public void error(String msg, Exception e) {
		errors.add(msg+"\n"+ Arrays.toString(e.getStackTrace()));
	}


    public String getFileName() {return fileName;}

    public static Code dbg(int literalIndex, int line, int charPos) {
        return null;
    }
}

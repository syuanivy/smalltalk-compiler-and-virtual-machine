package smalltalk.compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import smalltalk.compiler.codegen.Code;
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
		// parse class(es)
		// define symbols


        ParserRuleContext tree = parseClasses(input);
        defSymbols(tree);

        // resolve symbols
        // gen code


      //  CodeGenerator gen = new CodeGenerator(this);
      //  Code file = gen.visit(tree);
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


    // Convenience methods for code gen

	public static Code push_nil() 				{ return Code.of(Bytecode.NIL); }
	public static Code push_char(int c)			{ return Code.of(Bytecode.PUSH_CHAR).join(Utils.shortToBytes(c)); }
	public static Code push_int(int v) 			{ return Code.of(Bytecode.PUSH_INT).join(Utils.intToBytes(v)); }

	// Error support

	public void error(String msg) {
		errors.add(msg);
	}

	public void error(String msg, Exception e) {
		errors.add(msg+"\n"+ Arrays.toString(e.getStackTrace()));
	}

    public static Code method_return() {
        return null;
    }

    public static Code push_self() {
        return null;
    }

    public static Code pop() {
        return null;
    }

    public String getFileName() {
        return null;
    }

    public static Code dbg(int literalIndex, int line, int charPos) {
        return null;
    }
}

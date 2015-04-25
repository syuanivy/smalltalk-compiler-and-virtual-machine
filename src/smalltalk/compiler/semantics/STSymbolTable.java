package smalltalk.compiler.semantics;

import org.antlr.symtab.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import smalltalk.compiler.parser.SmalltalkBaseListener;
import smalltalk.compiler.parser.SmalltalkParser;

import java.util.ArrayList;
import java.util.List;

public class STSymbolTable {
	public static final String[] predefinedSymbols = {"true", "false", "nil", "self", "super" };
	public final GlobalScope GLOBALS;


	public STSymbolTable() {
        this.GLOBALS = new GlobalScope(null);
		initPredefinedSymbols();
	}

    public void initPredefinedSymbols() {
        for(String s: predefinedSymbols){
            STPrimitiveType predefinedSym = new STPrimitiveType(s);
            defineGlobalSymbol(predefinedSym);
        }
	}

	public void defineGlobalSymbol(Symbol s) {
		this.GLOBALS.define(s);
	}



}

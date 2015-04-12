package smalltalk.compiler;

import org.antlr.symtab.GlobalScope;
import org.antlr.symtab.Symbol;
import org.antlr.symtab.VariableSymbol;

public class STSymbolTable {
	public static final String[] predefinedSymbols = {  };
	public final GlobalScope GLOBALS;

	public STSymbolTable() {
		this.GLOBALS = new GlobalScope(null);
		initPredefinedSymbols();
	}

	public void initPredefinedSymbols() {
	}

	public void defineGlobalSymbol(Symbol s) {
		this.GLOBALS.define(s);
	}
}

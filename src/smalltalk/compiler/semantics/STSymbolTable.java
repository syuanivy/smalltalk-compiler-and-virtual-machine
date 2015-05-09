package smalltalk.compiler.semantics;

import org.antlr.symtab.*;

public class STSymbolTable {

	public final GlobalScope GLOBALS;


	public STSymbolTable() {
        this.GLOBALS = new GlobalScope(null);
	}
}

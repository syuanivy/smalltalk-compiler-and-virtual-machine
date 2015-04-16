package smalltalk.compiler.semantics;

import org.antlr.symtab.VariableSymbol;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import smalltalk.compiler.parser.SmalltalkParser;

/** Set the symbol references in the parse tree nodes for ID and lvalues.
 *  Check that the left-hand side of assignments are variables. Other
 *  unknown symbols could simply be references to type names that will
 *  be compiled later. Mostly done to verify scopes/symbols in
 *  {@link smalltalk.test.TestIDLookup}.
 */
public class ResolveSymbols extends SetScope {
	public ResolveSymbols(smalltalk.compiler.Compiler compiler) {
		super(compiler);
	}

	@Override
	public void enterId(@NotNull SmalltalkParser.IdContext ctx) {
		ctx.sym = null;
	}

	@Override
	public void enterLvalue(@NotNull SmalltalkParser.LvalueContext ctx) {
		ctx.sym = null;
	}

	public VariableSymbol checkIDExists(Token ID) {
		return null;
	}
}

package smalltalk.compiler.semantics;

import org.antlr.symtab.Symbol;
import org.antlr.symtab.VariableSymbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import smalltalk.compiler.Compiler;
import smalltalk.compiler.parser.SmalltalkParser;

/** Set the symbol references in the parse tree nodes for ID and lvalues.
 *  Check that the left-hand side of assignments are variables. Other
 *  unknown symbols could simply be references to type names that will
 *  be compiled later. Mostly done to verify scopes/symbols in
 *  {@link smalltalk.test.TestIDLookup}.
 */
public class ResolveSymbols extends SetScope {


    public ResolveSymbols(Compiler compiler) {
        super(compiler);
    }

    @Override
    public void enterId(@NotNull SmalltalkParser.IdContext ctx) {
        ctx.sym = currentScope.resolve(ctx.ID().getText());
    }

    @Override
    public void enterLvalue(@NotNull SmalltalkParser.LvalueContext ctx) {
        if(isResolvable(ctx.ID().getText()))
            ctx.sym = (VariableSymbol)currentScope.resolve(ctx.ID().getText());
    }

    private boolean isResolvable(String s) {
        Symbol v = currentScope.resolve(s);
        boolean res = false;
        if ( v == null ){
            String print = currentScope.toQualifierString(">>");
            System.out.println(print);
            compiler.error("unknown variable "+s+" in "+currentScope.toQualifierString(">>"));
        }

        else if ( !(v instanceof VariableSymbol) )
            compiler.error("symbol "+v+ " is not a variable/argument in "+
                    currentScope.toQualifierString(">>"));
        else
            res = true;
        return res;

    }


}

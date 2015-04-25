package smalltalk.compiler.semantics;

import org.antlr.symtab.FieldSymbol;
import org.antlr.symtab.Scope;

/**
 * Created by Shuai on 4/24/15.
 */
public class STInstanceVar extends FieldSymbol {

    public STInstanceVar(String name) {
        super( name);
    }
}

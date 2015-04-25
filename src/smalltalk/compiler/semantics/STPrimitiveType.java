package smalltalk.compiler.semantics;

import org.antlr.symtab.BaseSymbol;
import org.antlr.symtab.Type;

/**
 * Created by Shuai on 4/23/15.
 */
public class STPrimitiveType extends BaseSymbol implements Type {
    public STPrimitiveType(String name) {
        super(name);
    }

}



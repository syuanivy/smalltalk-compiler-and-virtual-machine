package smalltalk.compiler.semantics;

import org.antlr.v4.runtime.ParserRuleContext;
import smalltalk.vm.primitive.Primitive;

/**
 * Created by Shuai on 4/15/15.
 */
public class STPrimitiveMethod extends STMethod {
    public final Primitive primitive;

    public STPrimitiveMethod(String name, ParserRuleContext tree, String primitiveName) {
        super(name, tree);
        this.primitive = Enum.valueOf(Primitive.class, primitiveName);
    }

}

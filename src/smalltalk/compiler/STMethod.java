package smalltalk.compiler;

import org.antlr.v4.runtime.ParserRuleContext;

/** A Smalltalk method symbol. It's like a block with a name.
 *
 *  Args and first level locals for a method are in the same scope.
 */
public class STMethod extends STBlock {
	public boolean isClassMethod;

	public STMethod(String name, ParserRuleContext tree) {
		super(name, tree);
	}

	public boolean isMethod() { return true; }

	@Override
	public String toString() {
		return super.toString();
	}
}

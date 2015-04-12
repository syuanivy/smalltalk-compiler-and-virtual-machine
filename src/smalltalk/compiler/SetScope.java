package smalltalk.compiler;

import org.antlr.symtab.Scope;
import org.antlr.v4.runtime.misc.NotNull;

public class SetScope extends SmalltalkBaseListener {
	public final Compiler compiler;
	public Scope currentScope; // block or method

	public SetScope(Compiler compiler) {
		this.compiler = compiler;
		pushScope(compiler.symtab.GLOBALS);
	}

	@Override
	public void enterClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
		pushScope(ctx.scope);
	}

	@Override
	public void exitClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
		popScope();
	}

	public void pushScope(Scope scope) {
		if ( scope==null ) return;
//		System.out.println("push " + scope.getName());
		currentScope = scope;
	}

	public void popScope() {
		if ( currentScope==null ) return;
//		if ( currentScope.getEnclosingScope()!=null ) {
//			System.out.println("popping from " + currentScope.getName() + " to " + currentScope.getEnclosingScope().getName());
//		}
//		else {
//			System.out.println("popping from " + currentScope.getName() + " to null");
//		}
		currentScope = currentScope.getEnclosingScope();
	}
}

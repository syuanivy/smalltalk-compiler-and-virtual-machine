package smalltalk.compiler.semantics;

import org.antlr.symtab.Scope;
import org.antlr.symtab.Utils;
import org.antlr.v4.runtime.misc.NotNull;
import smalltalk.compiler.Compiler;
import smalltalk.compiler.parser.SmalltalkBaseListener;
import smalltalk.compiler.parser.SmalltalkParser;

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

    @Override
    public void enterMain(@NotNull SmalltalkParser.MainContext ctx) {
        if ( ctx.body() == null || ctx.body().getChildCount()==0 ) return;
        pushScope(ctx.classScope);
        pushScope(ctx.scope);
    }

    @Override
    public void exitMain(@NotNull SmalltalkParser.MainContext ctx) {
        if ( ctx.body() == null || ctx.body().getChildCount()==0 ) return;
        popScope(); // pop main method
        popScope(); // pop MainClass
    }

    @Override
    public void enterSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
        SmalltalkParser.MethodContext methodNode =
                (SmalltalkParser.MethodContext) Utils.getAncestor(ctx, SmalltalkParser.RULE_method);
        pushScope(methodNode.scope);
    }

    @Override
    public void exitSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
        popScope();
    }

    @Override
    public void enterBlock(@NotNull SmalltalkParser.BlockContext ctx) {
        pushScope(ctx.scope);
    }

    @Override
    public void exitBlock(@NotNull SmalltalkParser.BlockContext ctx) {
        popScope();
    }

    public void pushScope(Scope scope) {
        if ( scope==null ) return;
        currentScope = scope;
    }

    public void popScope() {
        if ( currentScope==null ) return;
        currentScope = currentScope.getEnclosingScope();
    }
}

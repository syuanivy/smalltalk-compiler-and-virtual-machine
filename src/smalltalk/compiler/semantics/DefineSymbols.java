package smalltalk.compiler.semantics;


import org.antlr.symtab.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import smalltalk.compiler.parser.SmalltalkBaseListener;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.Compiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 4/24/15.
 */
public class DefineSymbols extends SmalltalkBaseListener {
    public Scope currentScope;
    public final Compiler compiler;
    public STMethod currentMethod;

    public DefineSymbols(Compiler compiler) {
        this.compiler = compiler;
        pushScope(compiler.symtab.GLOBALS);
    }


    @Override
    public void enterClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
        String superClass = null;
        if(ctx.superName != null )
            superClass = ctx.superName.getText();
        else if ( !ctx.className.equals("Object") )
            superClass = "Object";

        STClass c = new STClass(ctx.className.getText(),superClass, compiler.symtab);
        c.setEnclosingScope(currentScope);
        currentScope.define(c);
        ctx.scope = c;
        pushScope(c);

    }

    @Override
    public void exitClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
        popScope();
    }

    @Override
    public void enterLocalVars(@NotNull SmalltalkParser.LocalVarsContext ctx) {
        List<TerminalNode> ids = ctx.ID();
        for(TerminalNode id: ids){
            VariableSymbol i;
            if(ctx.getParent() instanceof SmalltalkParser.InstanceVarsContext)  //fields
                i = new STInstanceVar(id.getText());
            else
                i = new VariableSymbol(id.getText());    //locals
            i.setScope(currentScope);
            currentScope.define(i);
        }
    }

/*
    //fields
    @Override
    public void enterInstanceVars(@NotNull SmalltalkParser.InstanceVarsContext ctx) {
        List<TerminalNode> ids = ctx.localVars().ID();
        for(TerminalNode id: ids){
            STInstanceVar i = new STInstanceVar(id.getText());
            i.setScope(currentScope);
            currentScope.define(i);
        }
    }
*/


    @Override
    public void exitClassMethod(@NotNull SmalltalkParser.ClassMethodContext ctx) {
        ctx.method().scope.isClassMethod = true;
    }

    @Override
    public void enterNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx) {
        ctx.methodBlock().selector = ctx.ID().getText();
        ctx.methodBlock().args = new ArrayList<>();
    }



    @Override
    public void enterOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx) {
        ctx.methodBlock().selector = ctx.bop().getText();
        TerminalNode arg = ctx.ID();
        ctx.methodBlock().args = new ArrayList<>();
        ctx.methodBlock().args.add(arg.getText());
    }


    @Override
    public void enterKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx) {
        List<TerminalNode> keywords = ctx.KEYWORD();
        StringBuffer bf = new StringBuffer();
        for(TerminalNode k: keywords){
            bf.append(k.getText());
        }
        ctx.methodBlock().selector = bf.toString();
        List<TerminalNode> args = ctx.ID();
        ctx.methodBlock().args = new ArrayList<>();
        for(TerminalNode arg : args) {
            ctx.methodBlock().args.add(arg.getText());
        }
    }


    @Override
    public void enterSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
        SmalltalkParser.MethodContext methodCtx = (SmalltalkParser.MethodContext)Utils.getAncestor(ctx, SmalltalkParser.RULE_method);
        STMethod m = new STMethod(ctx.selector, methodCtx);
        List<String> args = ctx.args;
        for(String arg: args)
            m.define(new ParameterSymbol(arg));
        currentScope.define(m);
        methodCtx.scope = m;
        currentMethod = m;
        m.setEnclosingScope(currentScope);
        pushScope(m);

    }

    @Override
    public void exitSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
        if(Utils.getAncestor(ctx, SmalltalkParser.RULE_method) != null)
            popScope();
    }

    @Override
    public void enterPrimitiveMethodBlock(@NotNull SmalltalkParser.PrimitiveMethodBlockContext ctx) {
        SmalltalkParser.MethodContext methodCtx = (SmalltalkParser.MethodContext)ctx.getParent();
        String primitive = ctx.SYMBOL().getText().substring(1); //get rid of #
        STPrimitiveMethod m = new STPrimitiveMethod(ctx.selector, methodCtx, primitive);
        currentScope.define(m);
        methodCtx.scope = m;
        currentMethod = m;
        m.setEnclosingScope(currentScope);
    }

    @Override
    public void enterLvalue(@NotNull SmalltalkParser.LvalueContext ctx) {
        VariableSymbol v = new VariableSymbol(ctx.ID().getText());
        currentScope.define(v);
        v.setScope(currentScope);
        v.setDefNode(ctx);
    }



    @Override
    public void enterBlock(@NotNull SmalltalkParser.BlockContext ctx) {
        STBlock b;
        if(currentScope instanceof STMethod)
            b = new STBlock(currentMethod, ctx);
        else
            b = new STBlock(currentMethod.getName(), ctx);
        b.setDefNode(ctx);
        b.setEnclosingScope(currentScope);
        currentScope.define(b);
        pushScope(b);

    }

    @Override
    public void exitBlock(@NotNull SmalltalkParser.BlockContext ctx) {
        popScope();
    }


    @Override
    public void enterBlockArgs(@NotNull SmalltalkParser.BlockArgsContext ctx) {
        List<TerminalNode> args = ctx.ID();
        for(TerminalNode arg : args){
            ParameterSymbol p = new ParameterSymbol(arg.getText());
            p.setScope(currentScope);
            currentScope.define(p);
        }
    }
    @Override
    public void enterMain(@NotNull SmalltalkParser.MainContext ctx) {
        if ( ctx.body() == null || ctx.body().getChildCount()==0 ) return;

        STClass mainClass = new STClass("MainClass", "Object", compiler.symtab);
        ctx.classScope = mainClass;
        currentScope.define(mainClass);
        pushScope(mainClass);

        STMethod m = new STMethod("main", ctx);
        ctx.scope = m;
        currentScope.define(m);
        m.setEnclosingScope(currentScope);
        currentMethod = m;
        pushScope(m);
    }

    @Override
    public void exitMain(@NotNull SmalltalkParser.MainContext ctx) {
        if ( ctx.body() == null || ctx.body().getChildCount()==0 ) return;
        popScope(); // pop main method
        popScope(); // pop MainClass
    }


    private void pushScope(Scope s) {
        currentScope = s;
    }

    private void popScope() {
        currentScope = currentScope.getEnclosingScope();
    }
}

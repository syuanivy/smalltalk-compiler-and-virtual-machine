package smalltalk.compiler.semantics;

import org.antlr.symtab.GlobalScope;
import org.antlr.symtab.LocalScope;
import org.antlr.symtab.Scope;
import org.antlr.symtab.Type;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;
import smalltalk.compiler.parser.SmalltalkBaseListener;
import smalltalk.compiler.parser.SmalltalkParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shuai on 4/24/15.
 */
public class DefineSymbols extends SmalltalkBaseListener {
    public STSymbolTable symtab;
    public Scope currentScope;

    public DefineSymbols(STSymbolTable symtab) {
        this.symtab = symtab;
        pushScope(symtab.GLOBALS);
    }
    @Override
    public void enterFile(@NotNull SmalltalkParser.FileContext ctx) {
        ctx.scope = (GlobalScope)currentScope;
    }

    @Override
    public void exitFile(@NotNull SmalltalkParser.FileContext ctx) {
        popScope();
    }

    @Override
    public void enterClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
        String superClass = null;
        if(ctx.superName != null )
            superClass = ctx.superName.getText();
        STClass c = new STClass(ctx.className.getText(),superClass, symtab);
        c.setDefNode(ctx);
        c.setEnclosingScope(currentScope);
        currentScope.define(c);
        ctx.scope = c;
        pushScope(c);

    }

    @Override
    public void exitClassDef(@NotNull SmalltalkParser.ClassDefContext ctx) {
        popScope();
    }

    //fields
    @Override
    public void enterInstanceVars(@NotNull SmalltalkParser.InstanceVarsContext ctx) {
        List<TerminalNode> ids = ctx.localVars().ID();
        for(TerminalNode id: ids){
            STInstanceVar i = new STInstanceVar(id.getText());
            i.setScope(currentScope);
            i.setDefNode(ctx.localVars());
            currentScope.define(i);
        }
    }


    @Override
    public void exitClassMethod(@NotNull SmalltalkParser.ClassMethodContext ctx) {
        ctx.method().scope.isClassMethod = true;
    }

    @Override
    public void enterNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx) {
        STMethod m = new STMethod(ctx.ID().getText(), ctx);
        ctx.scope = m;
        m.setEnclosingScope(currentScope);
        m.setDefNode(ctx);
        currentScope.define(m);
        ctx.methodBlock().selector = m.getName();
        pushScope(m);
    }

    @Override
    public void exitNamedMethod(@NotNull SmalltalkParser.NamedMethodContext ctx) {
        popScope();
    }

    @Override
    public void enterOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx) {
        STMethod m = new STMethod(ctx.bop().getText(), ctx);
        ctx.scope = m;
        m.setEnclosingScope(currentScope);
        m.setDefNode(ctx);
        currentScope.define(m);
        ctx.methodBlock().selector = m.getName();
        TerminalNode arg = ctx.ID();
        ctx.methodBlock().args = new ArrayList<>();
        ctx.methodBlock().args.add(arg.getText());
        pushScope(m);
    }

    @Override
    public void exitOperatorMethod(@NotNull SmalltalkParser.OperatorMethodContext ctx) {
        popScope();
    }

    @Override
    public void enterKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx) {

        List<TerminalNode> keywords = ctx.KEYWORD();
        StringBuffer bf = new StringBuffer();
        for(TerminalNode k: keywords){
            bf.append(k.getText());
        }
        STMethod m = new STMethod(bf.toString(), ctx);
        ctx.scope = m;
        m.setEnclosingScope(currentScope);
        m.setDefNode(ctx);
        currentScope.define(m);
        ctx.methodBlock().selector = m.getName();
        List<TerminalNode> args = ctx.ID();
        ctx.methodBlock().args = new ArrayList<>();
        for(TerminalNode arg : args) {
            ctx.methodBlock().args.add(arg.getText());
        }
        pushScope(m);
    }

    @Override
    public void exitKeywordMethod(@NotNull SmalltalkParser.KeywordMethodContext ctx) {
        popScope();
    }


    @Override
    public void enterSmalltalkMethodBlock(@NotNull SmalltalkParser.SmalltalkMethodBlockContext ctx) {
        STBlock b = new STBlock((STMethod)currentScope,ctx );
        b.setDefNode(ctx);
        currentScope.define(b);
        b.setEnclosingScope(currentScope);
         }


    private void pushScope(Scope s) {
        currentScope = s;
    }

    private void popScope() {
        currentScope = currentScope.getEnclosingScope();
    }
}

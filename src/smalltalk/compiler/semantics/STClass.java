package smalltalk.compiler.semantics;

import org.antlr.symtab.ClassSymbol;
import org.antlr.symtab.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * Created by Shuai on 4/15/15.
 */
public class STClass extends ClassSymbol {
    public final STSymbolTable symtab; // to (lazily) look up superclasses

    public STClass(String name, String superClassName, STSymbolTable symtab) {
        super(name);
        setSuperClass(superClassName);
        this.symtab = symtab;
    }

    public int getFieldIndex(String name) {
        Symbol sym = resolve(name);
        return sym!=null && sym.getScope() instanceof STClass ? sym.getInsertionOrderNumber() : -1;
    }

    public STMethod resolveMethod(String name) {
        return (STMethod)super.resolveMethod(name);
    }

    @Override
    public String toString() {
        return "class "+name;
    }
}

package smalltalk.vm.primitive;

import org.antlr.symtab.FieldSymbol;
import org.antlr.symtab.MethodSymbol;
import org.stringtemplate.v4.ST;
import smalltalk.compiler.semantics.STClass;
import smalltalk.vm.VirtualMachine;

import java.util.List;
import java.util.Map;

import static org.antlr.symtab.Utils.map;

/** A meta class that has info about ST classes like Java's Class class.
 *
 *  Expose this as a (meta) object in VM but it has little functionality and
 *  is mainly for uniformity that classes are also objects.
 */
public class STMetaClassObject extends STObject {
	public final VirtualMachine vm;
	public final String name;
	public final STMetaClassObject superClass;

	public final List<String> fields;
	public final Map<String,STCompiledBlock> methods;

	STMetaClassObject(VirtualMachine vm, STClass classSymbol, String name, STMetaClassObject superClass, List<String> fields, Map<String, STCompiledBlock> methods) {
		super(null); // metaclass for a metaclass is 'this' but 'this' doesn't exist yet; see override of getSTClass()
		this.vm = vm;
		// make space for ALL fields, including inherited ones
		// for all methods defined in classSymbol, map method name to its compiled method
		// set enclosingClass for all nested blocks within method
        this.name = name;
        this.superClass = superClass;
        this.fields = fields;
        this.methods = methods;
    }

	@Override
	public STMetaClassObject getSTClass() {
		return this;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		VirtualMachine vm = ctx.vm;
		ctx.vm.assertNumOperands(nArgs+1); // ensure args + receiver
		int firstArg = ctx.sp - nArgs + 1;
		STObject receiver = null;
		STObject result = vm.nil();
		if ( firstArg-1 >= 0 ) receiver = ctx.stack[firstArg-1];
		switch ( primitive ) {
			case Object_Class_BASICNEW:
				break;
			case Object_Class_ERROR:
				vm.error(ctx.stack[firstArg].asString().toString());
				break;
		}
		return result;
	}

	public String getName() { return name; }

	public STCompiledBlock resolveMethod(String name) {
        return null;
	}

	public int getNumberOfFields() {
		return fields.size();
	}

	public String toTestString() {
		ST template = new ST(
			"name: <name>\n" +
			"superClass: <superClass.name>\n" +
			"fields: <fields; separator={,}>\n" +
			"methods:\n" +
			"    <methods; separator={<\\n>}>"
		);
		template.add("name", name);
		template.add("superClass", superClass);
		template.add("fields", fields);
		template.add("methods", map(methods.values(), STCompiledBlock::toTestString));
		return template.render();
	}

	@Override
	public String toString() {
		return "class "+name;
	}
}

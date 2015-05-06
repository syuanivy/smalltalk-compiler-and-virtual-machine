package smalltalk.vm.primitive;

import org.antlr.symtab.Utils;
import smalltalk.vm.VirtualMachine;

import java.util.Arrays;
import java.util.List;

/** */
public class STArray extends STObject {
	public final STObject[] elements;

	public STArray(VirtualMachine vm, int n, STObject fill) {
		super(vm.lookupClass("Array"));
        elements = new STObject[n];
        for (STObject o: elements)
            o = fill;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		return null;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("");
        for(STObject o : elements){
            buffer.append(o.toString());
            buffer.append(". ");
        }
        String s = buffer.toString(); // with ". " at the end

        return "{"+ s.substring(0,s.length()-2)+"}";
	}
}

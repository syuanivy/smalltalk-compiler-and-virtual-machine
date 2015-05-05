package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

/** A backing object for smalltalk integers */
public class STInteger extends STObject {
	public final int v;

	public STInteger(VirtualMachine vm, int v) {
		super(vm.lookupClass("Integer"));
		this.v = v;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		return null;
	}

	@Override
	public String toString() {
		return String.valueOf(v);
	}
}

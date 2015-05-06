package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

public class STCharacter extends STObject {
	public final int c;

	public STCharacter(VirtualMachine vm, int c) {
		super(vm.lookupClass("Character"));
		this.c = c;
        System.out.println((char)c);
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		return null;
	}

	@Override
	public String toString() {
		return "$"+(char) c;
	}
}

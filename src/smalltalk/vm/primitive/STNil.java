package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

public class STNil extends STObject {
	public STNil(VirtualMachine vm) {
		super(vm.lookupClass("UndefinedObject"));
	}

	@Override
	public String toString() {
		return "nil";
	}
}

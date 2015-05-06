package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

public class STString extends STObject {
	public final String s;

	public STString(VirtualMachine vm, char c) {
		this(vm, String.valueOf(c));
	}

	public STString(VirtualMachine vm, String s) {
		super(vm.lookupClass("String"));
		this.s = s;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		VirtualMachine vm = ctx.vm;
		vm.assertNumOperands(nArgs+1); // ensure args + receiver
		int firstArg = ctx.sp - nArgs + 1;
		STObject receiverObj = ctx.stack[firstArg - 1];
		STObject result = vm.nil();
        String s1,s2;
		switch ( primitive ) {
            case String_CAT:
                s1 = receiverObj.toString();
                s2 = ctx.stack[firstArg].toString();
                ctx.sp--; //pop for arg1
                ctx.sp--; //pop for receiver
                result = new STString(vm, s1+s2);
                break;
            case String_EQ:
                STObject arg = ctx.stack[firstArg];
                ctx.sp--;
                ctx.sp--;
                result = vm.newBoolean(receiverObj.toString() == arg.toString());
                break;

		}
		return result;
	}

	public STString asString() { return this; }
	public String toString() { return s; }
}

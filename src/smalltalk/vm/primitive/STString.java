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
            case String_ASARRAY:
                ctx.sp--;
                STArray array = new STArray(vm,((STString)receiverObj).s.length(), vm.nil());
                for(int i = 0; i < ((STString)receiverObj).s.length(); i++ ){
                    array.elements[i] = vm.newCharacter(((STString) receiverObj).s.charAt(i));
                }
                result = array;
                break;
            case String_Class_NEW:
                STObject content = ctx.stack[firstArg];
                ctx.sp--;
                ctx.sp--;
                if(content instanceof  STString)
                    result = content;
                else
                    result = new STString(vm, (char)((STCharacter)content).c);
                break;

		}
		return result;
	}

	public STString asString() { return this; }
	public String toString() { return s; }
}

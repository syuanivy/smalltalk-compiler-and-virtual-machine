package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;
import smalltalk.vm.exceptions.MessageNotUnderstood;

public class STCharacter extends STObject {
	public final int c;

	public STCharacter(VirtualMachine vm, int c) {
		super(vm.lookupClass("Character"));
		this.c = c;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        int firstArg = ctx.sp - nArgs + 1;
        STObject receiverObj = ctx.stack[firstArg - 1];
        STObject result = vm.nil();
        STObject arg1;
        int c;
        switch ( primitive ) {
            case Character_Class_NEW:
                arg1 = ctx.pop();// int value of the new character
                ctx.sp--; //pop receiver, 'Character'
                if(! (arg1 instanceof STInteger))
                    throw new MessageNotUnderstood("new char input not a integer?", null);
                c = ((STInteger) arg1).v;
                result = vm.newCharacter(c);
                break;
            case Character_ASINTEGER:
                ctx.sp--; //pop receiver, no argument
                if(!(receiverObj instanceof STCharacter))
                    throw new MessageNotUnderstood("receiver not STCharacter", null);
                c = ((STCharacter) receiverObj).c;
                result = vm.newInteger(c);
                break;
        }
        return result;
	}

	@Override
	public String toString() {
		return "$"+(char) c;
	}
}

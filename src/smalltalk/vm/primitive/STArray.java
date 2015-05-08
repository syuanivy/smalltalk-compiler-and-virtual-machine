package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;
import smalltalk.vm.exceptions.MessageNotUnderstood;


/** */
public class STArray extends STObject {
	public final STObject[] elements;

	public STArray(VirtualMachine vm, int n, STObject fill) {
		super(vm.lookupClass("Array"));
        elements = new STObject[n];
        for(int i = 0; i < n; i++){
            elements[i] = fill;
        }
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive)
    {
        VirtualMachine vm = ctx.vm;
        int firstArg = ctx.sp - nArgs + 1;
        STObject receiverObj = ctx.stack[firstArg - 1];
        STObject result = vm.nil();
        STObject arg1, arg2;
        int index, size;
        switch ( primitive ) {
            case Array_Class_NEW:
                arg1 = ctx.pop();// size of the array to new, should be STInteger
                ctx.sp--; //pop receiver
                if(! (arg1 instanceof STInteger))
                    throw new MessageNotUnderstood("array size not a integer?", null);
                size = ((STInteger) arg1).v;
                result = new STArray(vm, size, vm.nil());
                break;
            case Array_SIZE:
                ctx.sp--; //pop receiver, no argument
                if(!(receiverObj instanceof STArray))
                    throw new MessageNotUnderstood("receiver not STArray", null);
                size = ((STArray) receiverObj).elements.length;
                result = vm.newInteger(size);
                break;
            case Array_AT:
                arg1 = ctx.pop(); // index i of the STArray
                if(! (arg1 instanceof STInteger))
                    throw new MessageNotUnderstood("index is not an integer?", null);
                index = ((STInteger) arg1).v - 1;
                if(!(receiverObj instanceof STArray))
                    throw new MessageNotUnderstood("receiver not STArray", null);
                result = ((STArray)receiverObj).elements[index];
                ctx.sp--;//pop the receiver array
                break;
            case Array_AT_PUT:
                arg2 = ctx.pop(); //v to put into element
                arg1 = ctx.pop(); //index i to be modified in the elements
                ctx.sp--; //pop receiver

                if(! (arg1 instanceof STInteger))
                    throw new MessageNotUnderstood("index is not an integer?", null);
                index = ((STInteger) arg1).v - 1;
                if(!(receiverObj instanceof STArray))
                    throw new MessageNotUnderstood("receiver not STArray", null);
                ((STArray) receiverObj).elements[index] = arg2;
                break;
        }
        return result;
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

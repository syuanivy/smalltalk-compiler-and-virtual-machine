package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

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
                size = ((STInteger) arg1).v;
                result = new STArray(vm, size, vm.nil());
                break;
            case Array_SIZE:
                ctx.sp--; //pop receiver, no argument
                size = ((STArray) receiverObj).elements.length;
                result = vm.newInteger(size);
                break;
            case Array_AT:
                arg1 = ctx.pop(); // index i of the STArray
                index = ((STInteger) arg1).v - 1;
                result = ((STArray)receiverObj).elements[index];
                ctx.sp--;//pop the receiver array
                break;
            case Array_AT_PUT:
                arg2 = ctx.pop(); //v to put into element
                arg1 = ctx.pop(); //index i to be modified in the elements
                ctx.sp--; //pop receiver
                index = ((STInteger) arg1).v - 1;
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

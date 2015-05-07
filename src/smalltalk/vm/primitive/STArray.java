package smalltalk.vm.primitive;

import com.sun.xml.internal.ws.protocol.soap.MessageCreationException;
import org.antlr.symtab.Utils;
import smalltalk.vm.VirtualMachine;
import smalltalk.vm.exceptions.MessageNotUnderstood;

import java.util.Arrays;
import java.util.List;

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
        switch ( primitive ) {
            case Array_Class_NEW:
                arg1 = ctx.pop();// size of the array to new, should be STInteger
                ctx.sp--; //pop receiver
                if(! (arg1 instanceof STInteger))
                    throw new MessageNotUnderstood("array size not a integer?", null);
                int size = ((STInteger) arg1).v;
                result = new STArray(vm, size, vm.nil());
                ctx.push(result);
                break;
            case Array_SIZE:
                ctx.sp--; //pop receiver, no argument
                if(!(receiverObj instanceof STArray))
                    throw new MessageNotUnderstood("receiver not STArray", null);
                int l = ((STArray) receiverObj).elements.length;
                result = vm.newInteger(l);
                ctx.push(result);
                break;
            case Array_AT_PUT:
                arg2 = ctx.pop(); //else blk
                arg1 = ctx.pop(); //if blk
                ctx.pop(); //pop receiver
                /*if(receiverObj.b){
                    ctx.push(arg1);
                    BlockDescriptor.perform(ctx, 0, Primitive.valueOf("BlockDescriptor_VALUE"));
                }else{
                    ctx.push(arg2);
                    BlockDescriptor.perform(ctx,0,Primitive.valueOf("BlockDescriptor_VALUE"));
                }
                result = null;*/
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

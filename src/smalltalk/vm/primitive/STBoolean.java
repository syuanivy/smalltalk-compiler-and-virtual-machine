package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

/** */
public class STBoolean extends STObject {
	public final boolean b;

	public STBoolean(VirtualMachine vm, boolean b) {
		super(vm.lookupClass("Boolean"));
		this.b = b;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        int firstArg = ctx.sp - nArgs + 1;
        STBoolean receiverObj = (STBoolean) ctx.stack[firstArg - 1];
        STObject result = vm.nil();
        STObject arg1;
        switch ( primitive ) {
            case Boolean_NOT :
                Boolean not = Boolean.logicalXor(true,receiverObj.b);
                ctx.sp--;
                result = new STBoolean(vm, not);
                ctx.push(result);
                break;
            case Boolean_IFTRUE:
                if(receiverObj.b){// if true, execute the blk argument
                    BlockDescriptor.perform(ctx, 0, Primitive.valueOf("BlockDescriptor_VALUE"));
                }

                break;

        }
        return result;
    }

	@Override
	public String toString() {
		return String.valueOf(b);
	}
}

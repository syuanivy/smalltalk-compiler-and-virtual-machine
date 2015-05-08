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
        STObject arg1, arg2;
        switch ( primitive ) {
            case Boolean_NOT :
                Boolean not = Boolean.logicalXor(true,receiverObj.b);
                ctx.sp--;
                result = vm.newBoolean(not);
                break;
            case Boolean_IFTRUE:
                arg1 = ctx.pop();
                ctx.pop(); // pop receiver
                ctx.push(arg1);//push arg, which will become the receiver in the perform below
                if(receiverObj.b){// if true, execute the blk argument
                    BlockDescriptor.perform(ctx, 0, Primitive.valueOf("BlockDescriptor_VALUE"));
                    result = null;
                }
                break;
            case Boolean_IFTRUE_IFFALSE:
                arg2 = ctx.pop(); //else blk
                arg1 = ctx.pop(); //if blk
                ctx.pop(); //pop receiver
                if(receiverObj.b){
                    ctx.push(arg1);
                    BlockDescriptor.perform(ctx, 0, Primitive.valueOf("BlockDescriptor_VALUE"));
                }else{
                    ctx.push(arg2);
                    BlockDescriptor.perform(ctx,0,Primitive.valueOf("BlockDescriptor_VALUE"));
                }
                result = null;
                break;

        }
        return result;
    }

	@Override
	public String toString() {
		return String.valueOf(b);
	}
}

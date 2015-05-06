package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

/** This object is like a pointer to block or method. In response to
 *  a BLOCK bytecode, the VM pushes one of these descriptor objects on the
 *  operand stack.  This object responds to "value" messages by creating a
 *  {@link BlockContext} from this "prototype" object and making it the active
 *  context (pushing the context onto the {@link BlockContext} stack).
 *  If in loop, this descriptor is the factory that creates repeated contexts.
 *
 *  By extending STObject, I don't intend to expose to the ST programmer;
 *  I just need to push these onto the runtime operand stack, which is a
 *  stack of STObject.
 *
 *  See http://pharobooks.gforge.inria.fr/PharoByExampleTwo-Eng/latest/Block.pdf
 */
public class BlockDescriptor extends STObject {
	/** This object is a descriptor for which compiled block? */
	public final STCompiledBlock block;

	/** The immediately surrounding/enclosing method or block.
	 *  If this block is a block within the outermost block (i.e., the method),
	 *  the enclosing context is the same as the enclosing method context.
	 *
	 *  See {@link BlockContext#enclosingContext} for more details.
	 */
	public final BlockContext enclosingContext;

	/** A shortcut up the enclosingContext chain to the method in which the
	 *  block associated with this context is defined.  We need to locate
	 *  the method context that created us so that we can return properly
	 *  upon METHOD_RETURN bytecode. To perform a return, we unwind the
	 *  stack until we reach one level above enclosingMethodContext and
	 *  then push the return result on that context's stack.
	 *
	 *  See {@link BlockContext#enclosingMethodContext} for more details.
	 */
	public final BlockContext enclosingMethodContext;

	/** The receiver of the method that created this block descriptor.
	 *  SELF instruction in block passed to another method must return
	 *  the self of the method invocation that created block. E.g.,
	 *
	 *  test
	 *	 	[self foo] value
	 *
	 *  The self of [self foo] is same as self we sent test message to.
	 *  Passing block to another function should still see test's self:
	 *
	 *  test
	 *  	self bar: [self foo]
	 * 	bar: blk
	 * 		blk value
	 */
	public final STObject receiver;

	// visible only to the package so no one else can randomly create these objects
	public BlockDescriptor(STCompiledBlock blk, BlockContext activeContext) {
		super(activeContext.vm.lookupClass("BlockDescriptor"));
        this.block = blk;
        enclosingContext = activeContext;
        enclosingMethodContext = activeContext.enclosingMethodContext;
        receiver = activeContext.receiver;
    }

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        STObject receiver = ctx.pop();
        STObject arg1, arg2;
        BlockContext bc;
        STObject result = null;
        switch ( primitive ) {
            case BlockDescriptor_VALUE:
                bc = new BlockContext(vm, (BlockDescriptor)receiver);
                vm.pushContext(bc);
                break;
            case BlockDescriptor_VALUE_1_ARG:
                bc = new BlockContext(vm, (BlockDescriptor)receiver);
                arg1 = ctx.pop();
                bc.locals[0] = arg1;
                vm.pushContext(bc);
                break;
            case BlockDescriptor_VALUE_2_ARGS:
                bc = new BlockContext(vm, (BlockDescriptor)receiver);
                arg2 = ctx.pop();
                arg1 = ctx.pop();
                bc.locals[0] = arg1;
                bc.locals[1] = arg2;
                vm.pushContext(bc);
                break;
        }
        return result;// no result for block initiation; block just starts executing
	}

	@Override
	public String toString() {
		return "a BlockDescriptor";
	}
}

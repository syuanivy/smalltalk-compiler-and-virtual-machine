package smalltalk.vm.primitive;

public interface PrimitiveImplPtr {
	/** Execute code for primitive method, push result value unless null,
	 *  which means do not push anything.
	 */
	STObject perform(BlockContext ctx, int nArgs, Primitive primitive);
}

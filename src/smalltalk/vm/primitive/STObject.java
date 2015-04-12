package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;
import smalltalk.vm.exceptions.InternalVMException;

/** A Smalltalk instance. All fields initialized to nil.
 *  We combine all fields from all inherited classes into this one.  There is
 *  one STObject for every Smalltalk object.
 *
 *  This is unlike Timothy Budd's impl. See Fig 12.2 page 154 of PDF. He has
 *  a superObject chain.  Each object at depth 3 has 3 actual impl objects,
 *  one per depth.
 */
public class STObject {
	/** What kind of object am I? */
	public final STMetaClassObject metaclass;

	/** Which smalltalk-visible fields are defined all the way up the superclass chain? */
	public final STObject[] fields;

	STObject(STMetaClassObject metaclass) {
		this.metaclass = metaclass;
		fields = null;
		// Create empty slot for each field directly defined by metaclass
		// plus any fields inherited from super class.
		// Note: native backing objects like STBoolean do not have smalltalk-visible fields
		// so nfields == 0 and therefore vm can be null.
	}

	/** Which fields are directly defined? null if no fields */
	public STObject[] getFields() {
		return fields;
	}

	/** What kind of object am I? Analogous to Java's Object.getClass() */
	public STMetaClassObject getSTClass() {
		return null;
	}

	/** Analogous to Java's toString() */
	public STString asString() {
		if ( metaclass==null ) {
			throw new InternalVMException(null, "object "+toString()+" has null metaclass", null);
		}
		return null;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
		VirtualMachine vm = ctx.vm;
		vm.assertNumOperands(nArgs+1); // ensure args + receiver
		int firstArg = ctx.sp - nArgs + 1;
		STObject receiver = ctx.stack[firstArg-1];
		STObject result = vm.nil();
		switch ( primitive ) {
			case Object_ASSTRING:
				ctx.sp--; // pop receiver
				// if not overridden, ask the *java* backing object for an st string
				result =  receiver.asString();
				break;
			case Object_CLASSNAME :
				break;
			case Object_SAME : // SmallTalk = op.  same as == in Java (same object)
				break;
			case Object_HASH:
				break;
		}
		return result;
	}

	@Override
	public String toString() {
		if ( metaclass==null ) return "<no classdef>";
		return "a "+metaclass.getName();
	}
}

package smalltalk.vm.primitive;

import org.antlr.symtab.*;
import org.stringtemplate.v4.ST;
import smalltalk.compiler.parser.SmalltalkParser;
import smalltalk.compiler.semantics.STBlock;
import smalltalk.compiler.semantics.STClass;
import smalltalk.compiler.semantics.STMethod;
import smalltalk.compiler.semantics.STPrimitiveMethod;
import smalltalk.vm.Bytecode;

import java.util.List;

/** This object represents the compiled code for a block or method.
 *  It holds all of the bytecode and meta information about the block, such
 *  as the number of arguments and the number of local variables.
 *
 *  If this object is a placeholder for a primitive method, field primitive
 *  will be non-null.
 *
 *  If this object represents a compiled method, field blocks will be
 *  an array of pointers to the compiled code for all nested blocks of the
 *  method.
 *
 *  All blocks can reference literals method names and string literals ref'd within.
 *  These are stored in the literals field. The associated STString objects
 *  are cached in literalsAsSTStrings.
 *
 *  This object has a reference to the lexically enclosing class' metaclass,
 *  which is set by {@link STMetaClassObject} during construction.
 */
public class STCompiledBlock {
	public static final String testStringTemplate =
		"name: <name>\n" +
		"qualifiedName: <qualifiedName>\n" +
		"nargs: <nargs>\n" +
		"nlocals: <nlocals>\n"+
		"literals: <literals:{s | '<s>'}; separator={,}>\n" +
		"<assembly>"+
		"<if(blocks)>" +
		"blocks:\n"+
		"    <blocks; separator={<\\n>}>" +
		"<endif>";

	/** currently unused, but would be used to serialize a compiled block to disk */
	public static final String serializeTemplate =
		"name: <name>\n" +
		"qualifiedName: <qualifiedName>\n" +
		"nargs: <nargs>\n" +
		"nlocals: <nlocals>\n"+
		"literals: <literals:{s | `<s>`}; separator={,}>\n" + // unique separator
		"bytecode: <bytecode; separator={ }>" +
		"<if(blocks)>" +
		"blocks:\n"+
		"    <blocks>" +
		"<endif>";

	/** The simple name for a block or method like at:put: or foo:-local0 */
	public String name;

	/** The fully qualified name for this block or method like foo>>x or T>>x */
	public String qualifiedName;

    /**The error name when a class method is sent to Instance**/
    public String errorName;

	/** Of which class is this block a member? */
	public STMetaClassObject enclosingClass;

	/** The set of strings and symbols referenced by the {@link #bytecode} field. */
	public String[]   literals;

	/** Cache STString objects for literals */
	public STString[] literalsAsSTStrings;

	/** The byte code instructions for this specific block, if not primitive. */
	public byte[]     bytecode;

	/** If this is a compiled method, not just a block, this is the list
	 *  of all nested blocks within the method. The BLOCK instruction refers to
	 *  them by unique integer and finds them by indexing into this array.
	 *  The outermost method block is blocks[0].
	 *
	 *  This is unused for [...] blocks (i.e., not methods).
 	 */
	public STCompiledBlock[] blocks;

	/** The fixed number of arguments taken by this method */
	public final int nargs;

	/** The number of local variables defined within the block, not including the arguments */
	public final int nlocals;

	/** A pointer to the primitive implementing the method, if this field
	 *  is non-null.
 	 */
	public final Primitive primitive;

	public STCompiledBlock(STBlock blk, Boolean isClassMethod) {
        if(isClassMethod)
            name = "static " + blk.getName();
        else
            name = blk.getName();
        qualifiedName = blk.getQualifiedName(">>");
        errorName = getErrorName(blk, ">>");
        STClass classSymbol = blk.getEnclosingClass(STClass.class);
       // enclosingClass = new STMetaClassObject(classSymbol);?? how to initialize this?
        int Nargs = 0;
        int Nlocals = 0;

        for(Symbol s: blk.getSymbols()){
            if(s instanceof ParameterSymbol){
                s.setInsertionOrderNumber(Nargs);
                Nargs++;
            }
            else if(s instanceof FieldSymbol){
                s.setInsertionOrderNumber(999);

            }
            else if(s instanceof VariableSymbol){
                s.setInsertionOrderNumber(Nlocals);
                Nlocals++;
            }
        }
        nargs = Nargs;
        nlocals = Nlocals;

        blocks = new STCompiledBlock[blk.numNestedBlocks];
        if(blk.isMethod()){
            List<Scope> list = blk.getAllNestedScopes();
            int index;
            for(Scope b : list){
                if( b instanceof  STBlock){
                    index = ((STBlock) b).index;
                    blocks[index] = ((STBlock)b).compiledBlock;
                }
            }
        }

        if(blk instanceof STPrimitiveMethod)
            primitive = ((STPrimitiveMethod)blk).primitive;
        else
            primitive = null;
	}




    public boolean isPrimitive() { return primitive!=null; }

	public String toTestString() { return getAsString(testStringTemplate); }

	public String serialize() { return getAsString(serializeTemplate); }

	public String getAsString(String templateString) {
		ST template = new ST(templateString);
		template.add("name", name);
		template.add("qualifiedName", qualifiedName);
		template.add("nargs", nargs);
		template.add("nlocals", nlocals);
		template.add("literals", literals);
		template.add("bytecode", bytecode);
		template.add("assembly", Bytecode.disassemble(this, 0));
		template.add("blocks",
					 templateString==testStringTemplate ?
						 Utils.map(blocks, STCompiledBlock::toTestString) :
						 Utils.map(blocks, STCompiledBlock::serialize)
					);
		return template.render();
	}

    //for ClassMethodSentToInstance
    public String getErrorName(STBlock blk, String scopePathSeparator) {
        return blk.getEnclosingClass(STClass.class).getName() + scopePathSeparator + this.name;
    }
}

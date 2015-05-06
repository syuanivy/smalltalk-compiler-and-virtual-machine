package smalltalk.vm;

import org.antlr.symtab.ClassSymbol;
import org.antlr.symtab.Symbol;
import org.antlr.symtab.Utils;
import smalltalk.compiler.semantics.STClass;
import smalltalk.compiler.semantics.STSymbolTable;
import smalltalk.vm.exceptions.*;
import smalltalk.vm.primitive.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** A VM for a subset of Smalltalk.
 *
 *  3 HUGE simplicity factors in this implementation: we ignore GC,
 *  efficiency, and don't expose execution contexts to smalltalk programmers.
 *
 *  Because of the shared {@link SystemDictionary#objects} list (ThreadLocal)
 *  in SystemDictionary, each VirtualMachine must run in its own thread
 *  if you want multiple.
 */
public class VirtualMachine {
    /** The dictionary of global objects including class meta objects */
    public final SystemDictionary systemDict; // singleton

    /** "This is the active context itself. It is either a BlockContext
     *  or a BlockContext." BlueBook p 605 in pdf.
     */
    public BlockContext ctx;

    /** Trace instructions and show stack during exec? */
    public boolean trace = true;

    public VirtualMachine(STSymbolTable symtab) {
        systemDict = new SystemDictionary(this);
        systemDict.symtabToSystemDictionary(symtab);
        systemDict.initPredefinedObjects();
    }

    /** look up MainClass>>main and execute it */
    public STObject execMain() {
        STMetaClassObject mainClass = systemDict.lookupClass("MainClass");
        if(mainClass == null)
            return nil();
        STCompiledBlock main = mainClass.resolveMethod("main");
        if(main == null)
            return nil();
        STObject stObject = new STObject(mainClass);
        return exec(stObject,main);
    }

    /** Begin execution of the bytecodes in method relative to a receiver
     *  (self) and within a particular VM. exec() creates an initial
     *  method context to simulate a call to the method passed in.
     *
     *  Return the value left on the stack after invoking the method,
     *  or return self/receiver if there's nothing on the stack.
     */
    public STObject exec(STObject self, STCompiledBlock method) {
        BlockContext mainCtx = new BlockContext(this, method, self);
        mainCtx.enclosingMethodContext = mainCtx;
        mainCtx.enclosingContext = null;//??
        pushContext(mainCtx);

        int index, delta;
        BlockContext dest;
        // fetch-decode-execute loop
        while ( ctx.ip < ctx.compiledBlock.bytecode.length ) {
            if ( trace ) traceInstr(); // show instr first then stack after to show results
            int op = ctx.compiledBlock.bytecode[ctx.ip++];
            switch ( op ) {
                case Bytecode.NIL:
                    ctx.push(nil());
                    break;
                case Bytecode.SELF:
                    ctx.push(ctx.receiver);
                    break;
                case Bytecode.TRUE:
                    STBoolean t = new STBoolean(this, true);
                    ctx.push(t);
                    break;
                case Bytecode.FALSE:
                    STBoolean f = new STBoolean(this, false);
                    ctx.push(f);
                    break;
                case Bytecode.PUSH_CHAR:
                    int character = consumeChar(ctx.ip);
                    STCharacter c = new STCharacter(this, character);
                    ctx.push(c);
                    break;
                case Bytecode.PUSH_INT:
                    int integer = consumeInt(ctx.ip);
                    STInteger i = new STInteger(this, integer);
                    ctx.push(i);
                    break;
                case Bytecode.PUSH_FLOAT:
                    float floating = consumeFloat(ctx.ip);
                    STFloat flo= new STFloat(this,floating);
                    ctx.push(flo);
                    break;
                //case Bytecode.PUSH_FIELD:

                case Bytecode.PUSH_LOCAL:
                    delta = consumeShort(ctx.ip);
                    index = consumeShort(ctx.ip);
                    dest = getDestinationBlock(delta);
                    ctx.push(dest.locals[index]);
                    break;
                case Bytecode.PUSH_LITERAL:
                    index = consumeShort(ctx.ip); //get index of the literal
                    String s = ctx.compiledBlock.literals[index];
                    STString literal = new STString(this, s);
                    ctx.push(literal);
                    break;
                case Bytecode.PUSH_ARRAY:
                    STObject[] elements = consumeArray(ctx.ip);
                    STArray array = new STArray(this, elements.length, nil());
                    fillArray(array, elements);
                    ctx.push(array);
                    break;
                case Bytecode.STORE_LOCAL:
                    delta = consumeShort(ctx.ip);
                    index = consumeShort(ctx.ip);
                    dest = getDestinationBlock(delta);
                    dest.locals[index] = ctx.top();
                    break;
                case Bytecode.POP:
                    ctx.pop();
                    break;
                case Bytecode.SEND:
                    // done on the fly, not to be trusted :)
                    int nArgs = consumeShort(ctx.ip);
                    int firstArg = ctx.sp - nArgs + 1;
                    STObject recv = ctx.stack[firstArg-1];
                    int litindex = consumeShort(ctx.ip);
                    String msgName = ctx.compiledBlock.literals[litindex];
                    STCompiledBlock blk = recv.getSTClass().resolveMethod(msgName);
                    // if null, throw MessageNotUnderstood
                    if ( blk.isPrimitive() ) {
                        Primitive p = blk.primitive;
                        STObject result = blk.primitive.perform(ctx, nArgs);
                        if ( result!=null ) {
                            ctx.push(result);
                        }
                    } else { // it's a method call
                        // push context
                        BlockContext call = new BlockContext(this,blk, recv);
                        call.enclosingMethodContext = call;

                        pushContext(call);
                    }
                    break;
                case Bytecode.BLOCK:
                    index = consumeShort(ctx.ip);
                    blk = ctx.enclosingMethodContext.compiledBlock.blocks[index];
                    BlockDescriptor bd = new BlockDescriptor(blk, ctx);
                    ctx.push(bd);
                    break;
                case Bytecode.BLOCK_RETURN:
                    STObject v = ctx.pop();
                    popContext();
                    ctx.push(v);
                    break;
                case Bytecode.RETURN:
                    STObject returnValue = ctx.pop();
                    BlockContext returnToCtx = ctx.enclosingMethodContext.invokingContext;
                    if(returnToCtx == null)
                        return returnValue;
                    returnToCtx.push(returnValue);
                    ctx = returnToCtx;
                    break;
                case Bytecode.DBG:
                    ctx.ip += 2; //first arg, short
                    ctx.ip +=4;  //second arg, int
                    break;
            }
            if ( trace ) traceStack(); // show stack *after* execution
        }
        return ctx!=null ? ctx.receiver : null;
    }

    private BlockContext getDestinationBlock(int delta) {
        BlockContext dest;
        dest = ctx;
        for(int d = 0 ; d < delta; d++){
            dest = dest.enclosingContext;

        }
        return dest;
    }

    private void fillArray(STArray array, STObject[] elements) {
        for(int i = 0; i < elements.length; i++)
            array.elements[i] = elements[i];
    }


    public void error(String type, String msg) throws VMException {
        error(type, null, msg);
    }

    public void error(String type, Exception e, String msg) throws VMException {
        String stack = getVMStackString();
        switch ( type ) {
            case "MessageNotUnderstood":
                throw new MessageNotUnderstood(msg,stack);
            case "ClassMessageSentToInstance":
                throw new ClassMessageSentToInstance(msg,stack);
            case "IndexOutOfRange":
                throw new IndexOutOfRange(msg,stack);
            case "BlockCannotReturn":
                throw new BlockCannotReturn(msg,stack);
            case "StackUnderflow":
                throw new StackUnderflow(msg,stack);
            case "UndefinedGlobal":
                throw new UndefinedGlobal(msg,stack);
            case "MismatchedBlockArg":
                throw new MismatchedBlockArg(msg,stack);
            case "InternalVMException":
                throw new InternalVMException(e,msg,stack);
            case "UnknownClass":
                throw new UnknownClass(msg,stack);
            case "TypeError":
                throw new TypeError(msg,stack);
            case "UnknownField":
                throw new UnknownField(msg,stack);
            default :
                throw new VMException(msg,stack);
        }
    }

    public void error(String msg) throws VMException {
        error("unknown", msg);
    }

    public void pushContext(BlockContext ctx) {
        ctx.invokingContext = this.ctx;
        this.ctx = ctx;
    }

    public void popContext() { ctx = ctx.invokingContext; }

    public static STObject TranscriptStream_SHOW(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        vm.assertNumOperands(nArgs + 1); // ensure args + receiver
        int firstArg = ctx.sp - nArgs + 1;
        STObject receiverObj = ctx.stack[firstArg - 1];
        vm.assertEqualBackingTypes(receiverObj, "TranscriptStream");
        STObject arg = ctx.stack[firstArg];
        System.out.println(arg.asString());
        ctx.sp -= nArgs + 1; // pop receiver and arg
        return receiverObj;  // leave receiver on stack for primitive methods
    }

    public STMetaClassObject lookupClass(String id) {
        return systemDict.lookupClass(id);
    }

    public STObject newInstance(String className, Object ctorArg) {
        return null;
    }

    public STObject newInstance(STMetaClassObject metaclass, Object ctorArg) {
        return null;
    }

    public STObject newInstance(STMetaClassObject metaclass) {
        return null;
    }

    public STInteger newInteger(int v) {
        return null;
    }

    public STFloat newFloat(float v) {
        return null;
    }

    public STString newString(String s) {
        return new STString(this, s);
    }

    public STBoolean newBoolean(boolean b) {
        return new STBoolean(this, b);
    }

    public STNil nil() {
        return new STNil(this);
    }

    public int consumeShort(int index) {
        int x = getShort(index);
        ctx.ip += Bytecode.OperandType.SHORT.sizeInBytes;
        return x;
    }

    public int consumeInt(int index){
        int x = getInt(index);
        ctx.ip += Bytecode.OperandType.INT.sizeInBytes;
        return x;
    }


    public int consumeChar(int index){
        int x = getShort(index); //same size as short
   //     System.out.println("within consume: " + x);
        ctx.ip += Bytecode.OperandType.CHAR.sizeInBytes;
        return x;
    }

    public float consumeFloat(int index){
        int x = getInt(index);
        float y = Float.intBitsToFloat(x);
        ctx.ip += Bytecode.OperandType.FLOAT.sizeInBytes;
        return y;
    }

    public STObject[] consumeArray(int index) {
        int n = getShort(index);
        ctx.ip += Bytecode.OperandType.SHORT.sizeInBytes;
        STObject[] elements = new STObject[n];
        for(int i = n-1; i>=0; i--)
            elements[i] = ctx.pop(); // popped out in reversed order
        return elements;
    }


    // get short operand( or anything of size 2) out of bytecode sequence
    private int getShort(int index) {
        byte[] code = ctx.compiledBlock.bytecode;
        return Bytecode.getShort(code, index);
    }

    // get short operand (or anything of size 4)out of bytecode sequence
    private int getInt(int index) {
        byte[] code = ctx.compiledBlock.bytecode;
        return Bytecode.getInt(code, index);
    }


    // D e b u g g i n g

    void trace() {
        traceInstr();
        traceStack();
    }

    void traceInstr() {
        String instr = Bytecode.disassembleInstruction(ctx.compiledBlock, ctx.ip);
        System.out.printf("%-40s", instr);
    }

    void traceStack() {
        BlockContext c = ctx;
        List<String> a = new ArrayList<>();
        while ( c!=null ) {
            a.add( c.toString() );
            c = c.invokingContext;
        }
        Collections.reverse(a);
        System.out.println(Utils.join(a, ", "));
    }

    public String getVMStackString() {
        StringBuilder stack = new StringBuilder();
        BlockContext c = ctx;
        while ( c!=null ) {
            int ip = c.prev_ip;
            if ( ip<0 ) ip = c.ip;
            String instr = Bytecode.disassembleInstruction(c.compiledBlock, ip);
            String location = c.currentFile+":"+c.currentLine+":"+c.currentCharPos;
            String mctx = c.compiledBlock.qualifiedName + pLocals(c) + pContextWorkStack(c);
            String s = String.format("    at %50s%-20s executing %s\n",
                    mctx,
                    String.format("(%s)",location),
                    instr);
            stack.append(s);
            c = c.invokingContext;
        }
        return stack.toString();
    }

    public String pContextWorkStack(BlockContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i=0; i<=ctx.sp; i++) {
            if ( i>0 ) buf.append(", ");
            pValue(buf, ctx.stack[i]);
        }
        buf.append("]");
        return buf.toString();
    }

    public String pLocals(BlockContext ctx) {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for (int i=0; i<ctx.locals.length; i++) {
            if ( i>0 ) buf.append(", ");
            pValue(buf, ctx.locals[i]);
        }
        buf.append("]");
        return buf.toString();
    }

    public void pValue(StringBuilder buf, STObject v) {
        if ( v==null ) buf.append("null");
        else if ( v==nil() ) buf.append("nil");
        else if ( v instanceof STString) buf.append("'"+v.asString()+"'");
        else if ( v instanceof BlockDescriptor) {
            BlockDescriptor blk = (BlockDescriptor) v;
            buf.append(blk.block.name);
        }
        else if ( v instanceof STMetaClassObject ) {
            buf.append(v.toString());
        }
        else {
            STObject r = v.asString(); //getAsString(v);
            buf.append(r.toString());
        }
    }

    public void assertNumOperands(int i) {

    }
    public void assertEqualBackingTypes(STObject receiverObj, String transcriptStream){

    }

}
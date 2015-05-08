package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

/** A backing object for smalltalk integers */
public class STInteger extends STObject {
	public final int v;

	public STInteger(VirtualMachine vm, int v) {
		super(vm.lookupClass("Integer"));
		this.v = v;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        STObject result = ctx.vm.nil();

        switch (primitive){
            //x perform y
            case Integer_ADD:
                result = integerAdd(ctx, vm);
                break;
            case Integer_SUB:
                result = integerSub(ctx, vm);
                break;
            case Integer_MULT:
                result = intergerMult(ctx, vm);
                break;
            case Integer_DIV:
                result = integerDiv(ctx, vm);
                break;
            case Integer_LT:
                result = integerLT(ctx, vm);
                break;
            case Integer_LE:
                result = integerLE(ctx, vm);
                break;
            case Integer_GT:
                result = integerGT(ctx, vm);
                break;
            case Integer_GE:
                result = integerGE(ctx, vm);
                break;
            case Integer_EQ:
                result = integerEQ(ctx, vm);
                break;
            case Integer_MOD:
                result = integerMod(ctx, vm);
                break;
            case Integer_ASFLOAT:
                STObject integer = ctx.pop();
                result = vm.newFloat(((STInteger) integer).v);
                break;
        }
		return result;
	}

    private static STObject integerMod(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        int i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x % i_y;
        result = vm.newInteger(i_z);
        return result;
    }

    private static STObject integerEQ(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        boolean b;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        b = (i_x == i_y);
        result = vm.newBoolean(b);
        return result;
    }

    private static STObject integerGE(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        boolean b;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        b = (i_x >= i_y);
        result = vm.newBoolean(b);
        return result;
    }

    private static STObject integerGT(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        boolean b;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        b = (i_x > i_y);
        result = vm.newBoolean(b);
        return result;
    }

    private static STObject integerLE(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        boolean b;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        b = (i_x <= i_y);
        result = vm.newBoolean(b);
        return result;
    }

    private static STObject integerLT(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        boolean b;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        b = (i_x < i_y);
        result = vm.newBoolean(b);
        return result;
    }

    private static STObject integerDiv(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        int i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x / i_y;
        result = vm.newInteger(i_z);
        return result;
    }

    private static STObject intergerMult(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        int i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x * i_y;
        result = vm.newInteger(i_z);
        return result;
    }

    private static STObject integerSub(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        int i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x - i_y;
        result = vm.newInteger(i_z);
        return result;
    }

    private static STObject integerAdd(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        int i_x;
        int i_y;
        int i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x + i_y;
        result = vm.newInteger(i_z);
        return result;
    }

    @Override
	public String toString() {
		return String.valueOf(v);
	}
}

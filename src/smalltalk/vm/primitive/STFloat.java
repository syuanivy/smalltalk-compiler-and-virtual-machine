package smalltalk.vm.primitive;

import smalltalk.vm.VirtualMachine;

import java.text.DecimalFormat;

/** Backing class for Smalltalk Float. */
public class STFloat extends STObject {
	public final float v;

	public STFloat(VirtualMachine vm, float v) {
		super(vm.lookupClass("Float"));
		this.v = v;
	}

	public static STObject perform(BlockContext ctx, int nArgs, Primitive primitive) {
        VirtualMachine vm = ctx.vm;
        STObject result = ctx.vm.nil();

        switch (primitive){
            //x perform y
            case Float_ADD:
                result = floatAdd(ctx, vm);
                break;
            case Float_SUB:
                result = floatSub(ctx, vm);
                break;
            case Float_MULT:
                result = floatMult(ctx, vm);
                break;
            case Float_DIV:
                result = floatDiv(ctx, vm);
                break;
            case Float_LT:
                result = floatLT(ctx, vm);
                break;
            case Float_LE:
                result = floatLE(ctx, vm);
                break;
            case Float_GT:
                result = floatGT(ctx, vm);
                break;
            case Float_GE:
                result = floatGE(ctx, vm);
                break;
            case Float_EQ:
                result = floatEQ(ctx, vm);
                break;
        }
        return result;
	}

    private static STObject floatEQ(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
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

    private static STObject floatGE(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
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

    private static STObject floatGT(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
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

    private static STObject floatLE(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
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

    private static STObject floatLT(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
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

    private static STObject floatDiv(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
        float i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x / i_y;
        result = vm.newFloat(i_z);
        return result;
    }

    private static STObject floatMult(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
        float i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x * i_y;
        result = vm.newFloat(i_z);
        return result;
    }

    private static STObject floatSub(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
        float i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x - i_y;
        result = vm.newFloat(i_z);
        return result;
    }

    private static STObject floatAdd(BlockContext ctx, VirtualMachine vm) {
        STObject y;
        STObject x;
        float i_x;
        float i_y;
        float i_z;
        STObject result;
        y = ctx.pop();
        x = ctx.pop();
        i_x = ((STInteger)x).v;
        i_y = ((STInteger)y).v;
        i_z = i_x + i_y;
        result = vm.newFloat(i_z);
        return result;
    }

    @Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.#####");
		return df.format(v);
	}
}

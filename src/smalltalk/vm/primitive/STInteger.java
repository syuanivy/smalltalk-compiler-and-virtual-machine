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
        STObject result = ctx.vm.nil();
        STObject x, y;
        int i_x, i_y, i_z;
        boolean b;
        switch (primitive){
            //x perform y
            case Integer_ADD:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                i_z = i_x + i_y;
                result = new STInteger(ctx.vm, i_z);
                break;
            case Integer_SUB:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                i_z = i_x - i_y;
                result = new STInteger(ctx.vm, i_z);
                break;
            case Integer_MULT:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                i_z = i_x * i_y;
                result = new STInteger(ctx.vm, i_z);
                break;
            case Integer_DIV:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                i_z = i_x / i_y;
                result = new STInteger(ctx.vm, i_z);
                break;
            case Integer_LT:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                b = (i_x < i_y);
                result = new STBoolean(ctx.vm, b);
                break;
            case Integer_LE:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                b = (i_x <= i_y);
                result = new STBoolean(ctx.vm, b);
                break;
            case Integer_GT:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                b = (i_x > i_y);
                result = new STBoolean(ctx.vm, b);
                break;
            case Integer_GE:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                b = (i_x >= i_y);
                result = new STBoolean(ctx.vm, b);
                break;
            case Integer_EQ:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                b = (i_x == i_y);
                result = new STBoolean(ctx.vm, b);
                break;
            case Integer_MOD:
                y = ctx.pop();
                x = ctx.pop();
                i_x = ((STInteger)x).v;
                i_y = ((STInteger)y).v;
                i_z = i_x % i_y;
                result = new STInteger(ctx.vm, i_z);
                break;
            case Integer_ASFLOAT:
                x = ctx.pop();
                result = new STFloat( ctx.vm, ((STInteger)x).v);
                break;
        }
		return result;
	}

	@Override
	public String toString() {
		return String.valueOf(v);
	}
}

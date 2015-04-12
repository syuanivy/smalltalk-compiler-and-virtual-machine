package smalltalk.vm.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

public class InternalVMException extends VMException {
	public final Exception cause;
	public InternalVMException(Exception e, String msg, String vmStackTrace) {
		super(msg, vmStackTrace);
		cause = e;
	}

	@Override
	public String toString() {
		String message = getMessage();
		String name = getClass().getSimpleName();
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		if ( cause!=null ) {
			cause.printStackTrace(pw);
		}
		return name + ": " + message + "\n" + stackTrace +
			   "Caused by:\n" + sw.toString();
	}
}

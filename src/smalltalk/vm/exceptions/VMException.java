package smalltalk.vm.exceptions;

/** A VM runtime exception */
public class VMException extends RuntimeException {
	public final String stackTrace;
	public VMException(String message, String vmStackTrace) {
		super(message);
		this.stackTrace = vmStackTrace;
	}

	@Override
	public String toString() {
		String message = getLocalizedMessage();
		String name = getClass().getSimpleName();
	    return name + ": " + message + "\n" + stackTrace;
	}
}

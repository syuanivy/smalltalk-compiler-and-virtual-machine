package smalltalk.vm.exceptions;

public class UnknownClass extends VMException {
	public UnknownClass(String message, String vmStackTrace) {
		super(message, vmStackTrace);
	}
}

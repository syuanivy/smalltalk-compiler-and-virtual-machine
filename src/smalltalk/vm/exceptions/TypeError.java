package smalltalk.vm.exceptions;

public class TypeError extends VMException {
	public TypeError(String message, String vmStackTrace) {
		super(message, vmStackTrace);
	}
}

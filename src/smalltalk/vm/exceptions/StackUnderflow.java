package smalltalk.vm.exceptions;

public class StackUnderflow extends VMException {
	public StackUnderflow(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

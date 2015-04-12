package smalltalk.vm.exceptions;

public class IndexOutOfRange extends VMException {
	public IndexOutOfRange(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

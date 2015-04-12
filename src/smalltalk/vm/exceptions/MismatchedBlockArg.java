package smalltalk.vm.exceptions;

public class MismatchedBlockArg extends VMException {
	public MismatchedBlockArg(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

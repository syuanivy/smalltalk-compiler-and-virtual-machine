package smalltalk.vm.exceptions;

public class BlockCannotReturn extends VMException {
	public BlockCannotReturn(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

package smalltalk.vm.exceptions;

public class UndefinedGlobal extends VMException {
	public UndefinedGlobal(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

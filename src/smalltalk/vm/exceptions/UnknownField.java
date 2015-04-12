package smalltalk.vm.exceptions;

public class UnknownField extends VMException {
	public UnknownField(String message, String vmStackTrace) {
		super(message, vmStackTrace);
	}
}

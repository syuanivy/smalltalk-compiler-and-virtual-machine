package smalltalk.vm.exceptions;

public class MessageNotUnderstood extends VMException {
	public MessageNotUnderstood(String message, String stackTrace) {
		super(message, stackTrace);
	}
}

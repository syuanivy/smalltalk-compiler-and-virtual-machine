package smalltalk.vm.exceptions;

/**
 * Created by Shuai on 4/22/15.
 */
public class ClassMessageSentToInstance extends VMException {
    public ClassMessageSentToInstance(String message, String vmStackTrace) {
        super(message, vmStackTrace);
    }
}

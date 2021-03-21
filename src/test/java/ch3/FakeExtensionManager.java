package ch3;

import ch3.IExtensionManager;

public class FakeExtensionManager implements IExtensionManager {

    public boolean willBeValid = true;
    public Exception willThrow;

    @Override
    public boolean isValid(String fileName) {
        if (willThrow!=null) {
            try {
                throw willThrow;
            } catch (Exception e) {
                return false;
            }
        }
        return willBeValid;
    }
}

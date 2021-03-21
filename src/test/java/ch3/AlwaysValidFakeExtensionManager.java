package ch3;

import ch3.IExtensionManager;

public class AlwaysValidFakeExtensionManager implements IExtensionManager {

    @Override
    public boolean isValid(String fileName) {
        return true;
    }
}

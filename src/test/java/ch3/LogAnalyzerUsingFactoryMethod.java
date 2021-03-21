package ch3;

import ch3.FileExtensionManager;
import ch3.IExtensionManager;

public class LogAnalyzerUsingFactoryMethod {

    public boolean isValidLogFileName(String fileName)
    {
        return GetManager().isValid(fileName);
    }

    protected boolean isValid(String fileName) {
        FileExtensionManager mgr = new FileExtensionManager();
        return mgr.isValid(fileName);
    }

    public IExtensionManager GetManager() {
        return new FileExtensionManager();
    }
}

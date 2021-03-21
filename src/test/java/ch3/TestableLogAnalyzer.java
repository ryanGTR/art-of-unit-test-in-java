package ch3;

public class TestableLogAnalyzer extends LogAnalyzerUsingFactoryMethod {

    public IExtensionManager manager;
    public boolean isSupported;

    public TestableLogAnalyzer(IExtensionManager mgr) {
        manager = mgr;
    }

    public TestableLogAnalyzer() {

    }

    @Override
    protected boolean isValid(String fileName) {
       return isSupported;
    }

    @Override
    public IExtensionManager GetManager() {
        return  manager;
    }
}

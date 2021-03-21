package ch3;

class TestableLogAnalyzerWithoutStub extends LogAnalyzerUsingFactoryMethod_AnotherWay {

    boolean isSupported;

    @Override
    protected boolean isValid(String fileName) {
        return isSupported;
    }
}

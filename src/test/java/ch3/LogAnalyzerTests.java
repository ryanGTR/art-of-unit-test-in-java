package ch3;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LogAnalyzerTests {

    @Test
    public void isValidFileName_NameSupportedExtension_ReturnsTrue() {
        FakeExtensionManager myFakeManager = new FakeExtensionManager();
        myFakeManager.willBeValid = true;
        LogAnalyzer log = new LogAnalyzer(myFakeManager);
        boolean result = log.isValidFileName("anything.anyExtension");
        assertTrue(result);
    }

    @Test
    public void isValidFileName_ExtManagerThrowsException_ReturnsFalse()  {
        FakeExtensionManager myFakeManager = new FakeExtensionManager();
        myFakeManager.willThrow = new Exception("this is fake");
        LogAnalyzer log = new LogAnalyzer(myFakeManager);
        boolean result = log.isValidFileName("any exception");
        assertFalse(result);
    }

    @Test
    public void isValidFileName_SupportedExtension_ReturnsTrue(){
        FakeExtensionManager myFakeManager = new FakeExtensionManager();
        myFakeManager.willBeValid = true;
        ExtensionManagerFactory.setCustomManager(myFakeManager);


        LogAnalyzer log = new LogAnalyzer();

        boolean result = log.isValidFileName("anything.extension");
        assertTrue(result);
    }

    @Test
    public void overrideTest() {
        FakeExtensionManager stub = new FakeExtensionManager();
        stub.willBeValid = true;

        TestableLogAnalyzer logan = new TestableLogAnalyzer(stub);
        boolean result = logan.isValidLogFileName("file.ext");

        assertTrue(result);
    }

    @Test
    public void overrideTest_withoutStub() {

        TestableLogAnalyzerWithoutStub logan = new TestableLogAnalyzerWithoutStub();

        logan.isSupported = true;
        boolean result = logan.isValidLogFileName("file.txt");

        assertTrue(result);
    }



}
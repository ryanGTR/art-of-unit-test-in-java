package ch7;

import static org.mockito.Mockito.verify;

import ch5.FakeLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogAnalyzerTests extends BaseTestsClass {

    @Test
    public void analyze_emptyFile_throwException() {
        FakeTheLogger();
        LogAnalyzer la = new LogAnalyzer();

        Assertions.assertDoesNotThrow(() -> la.analyze("myEmptyFile.txt"));
    }

    @AfterEach
    public void tearDown() {
        LoggingFacility.logger = null;
    }
}

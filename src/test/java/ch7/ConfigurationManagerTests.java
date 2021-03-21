package ch7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class ConfigurationManagerTests extends BaseTestsClass {

    @Test
    public void analyze_emptyFile_throwException() {
        FakeTheLogger();
        ConfigurationManager cm = new ConfigurationManager();
        boolean configured = cm.isConfigured("something");
        assertTrue(configured);
    }

    @AfterEach
    public void tearDown() {
        LoggingFacility.logger = null;
    }

}

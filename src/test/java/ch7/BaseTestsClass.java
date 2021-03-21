package ch7;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterEach;

public class BaseTestsClass {

    ILogger FakeTheLogger() {
        LoggingFacility.logger = mock(ILogger.class);
        return LoggingFacility.getLogger();
    }

    @AfterEach
    public void tearDown() {
        // 在測試之間需要重置靜態資源
        LoggingFacility.logger = null;
    }

}

package ch4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogAnalyzerTest {

    @Test
    public void analyze_tooShortFileName_callsWebService() {
        FakeWebService mockService = new FakeWebService();
        LogAnalyzer log = new LogAnalyzer(mockService);
        String tooShortFileName = "abc.txt";
        log.Analyze(tooShortFileName);
        assertThat(mockService.lastError, containsString("Filename too short:abc.txt"));
    }

    @Test
    public void analyze_WebServiceThrows_sendsEmail() {
        FakeWebService stubService = new FakeWebService();
        stubService.toThrow = new RuntimeException("fake exception");

        FakeEmailService mockEmail = new FakeEmailService();
        LogAnalyzer2 log = new LogAnalyzer2(stubService, mockEmail);

        String tooShortFileName="abc.txt";
        log.Analyze(tooShortFileName);


        // 建立期望物件
        EmailInfo expectedEmail = new EmailInfo("someone@somewhere.com", "can't log", "fake exception");

        // 驗證實際物件上所有的屬性值是否與期望物件相同
        assertEquals(expectedEmail, mockEmail.emailInfo);
    }
}

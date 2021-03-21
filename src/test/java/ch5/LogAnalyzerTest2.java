package ch5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;


public class LogAnalyzerTest2 {

    @Test
    public void analyze_loggerThrows_CallWebService() {
        FakeWebService mockWebService = new FakeWebService();
        FakeLogger2 stubLogger = new FakeLogger2();
        stubLogger.willThrow = new RuntimeException("fake exception");

        LogAnalyzer2 analyzer2 = new LogAnalyzer2(stubLogger, mockWebService);
        analyzer2.setMinNameLength(8);
        String tooShortFileName = "abc.txt";

        analyzer2.analyze2(tooShortFileName);
        assertThat(mockWebService.messageToWebService, StringContains.containsString("fake exception"));
    }

    @Test
    public void Analyze_LoggerThrows_CallsWebService_ByMockito() {
        // 請注意 Mockito.spy 出來的物件，若未指定預期行為則會找實際 class 內容
        FakeWebService mockWebService = spy(FakeWebService.class);
        // 不論輸入任何參數，模擬拋出例外的行為
        FakeLogger2 stubLogger = mock(FakeLogger2.class);
        doThrow(new RuntimeException("fake exception"))
                                .when(stubLogger).logError(anyString());

        LogAnalyzer2 analyzer2 = new LogAnalyzer2(stubLogger, mockWebService);
        analyzer2.setMinNameLength(8);
        String tooShortFileName = "abc.ext";
        analyzer2.analyze(tooShortFileName);

        // 確認 web 服務的模擬物件有被正確呼叫，而且傳入的字串參數包含了 fake exception 的內容
       verify(mockWebService,times(1))
                                .write(contains("fake exception"));
    }

    @Test
    public void Analyze_LoggerThrows_CallsWebServiceWithObject_ByMockito() {
        FakeWebService mockWebService = spy(FakeWebService.class);
        FakeLogger2 stubLogger = mock(FakeLogger2.class);
        doThrow(new RuntimeException("fake exception"))
                                .when(stubLogger).logError(anyString());

        LogAnalyzer2 analyzer2 = new LogAnalyzer2(stubLogger, mockWebService);
        analyzer2.setMinNameLength(8);
        String tooShortFileName = "abc.ext";
        analyzer2.analyze2(tooShortFileName);

       verify(mockWebService, times(1))
                                .write(eq(new ErrorInfo(1000, "fake exception")));
        // 若無法實作 equals() 可使用 org.mockito.Matchers.refEq 比對屬性
        // .write(Matchers.refEq(new ErrorInfo(1000, "fake exception")));
    }

}


package ch5;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LogAnalyzerTest {

    @Test
    public void analyze_tooShortFileName_callLogger() {
        // 建立假物件
        FakeLogger logger = new FakeLogger();

        LogAnalyzer analyzer = new LogAnalyzer(logger);
        analyzer.minNameLength = 6;
        analyzer.analyze("a.txt");
        assertThat(logger.lastError, StringContains.containsString("too short"));
    }

    @Test
    public void analyze_tooShortFileName_callLogger_ByMockito() {
        // 建立模擬物件
        FakeLogger logger = mock(FakeLogger.class);

        LogAnalyzer analyzer = new LogAnalyzer(logger);
        analyzer.minNameLength = 6;
        analyzer.analyze("a.txt");

        // 使用 Mockito API 來驗證期望結果
        Mockito.verify(logger)
                                // 預期 logError 傳入參數
                                .logError(eq("Filename too short: a.txt"));
    }

    @Test
    public void returns_ByDefault_WorksForHardCodedArgument() {
        IFileNameRules fakeRules = mock(IFileNameRules.class);

        // 忽略參數內容，即任意字串
        given(fakeRules.isValidLogFileName("strict.txt")).willReturn(true);
        assertTrue(fakeRules.isValidLogFileName("strict.txt"));
    }

    @Test
    public void returns_argAny_WorksForHardCodedArgument() {
        IFileNameRules fakeRules = mock(IFileNameRules.class);

        // 強制方法被呼叫時要回傳假的值
        given(fakeRules.isValidLogFileName(anyString())).willReturn(true);
        assertTrue(fakeRules.isValidLogFileName("strict.txt"));
    }

    @Test
    public void returns_argAny_throws() {
        IFileNameRules fakeRules = mock(IFileNameRules.class);

        // 模擬拋出例外
        given(fakeRules.isValidLogFileName(anyString())).willThrow(new RuntimeException("fake exception"));

        // 驗證拋出例外
        assertThrows(RuntimeException.class, () -> {
            fakeRules.isValidLogFileName(anyString());
        });

    }





}

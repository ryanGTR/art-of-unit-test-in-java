package ch7;

import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDateTime;
import org.hamcrest.core.StringContains;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TimeLoggerTests {

    @Test
    public void SettingSystemTime_Always_ChangesTime() {
        // 設定一個假日期
        SystemTime.setDate(LocalDateTime.of(2000, 1, 1, 0, 0));
        String output = TimeLogger.createMessage("a");

        assertThat(output, StringContains.containsString("2000-01-01"));
    }

    @AfterEach
    public void tearDown() {
        // 在每個測試結束時，重置日期與時間
        SystemTime.resetDate();
    }

}

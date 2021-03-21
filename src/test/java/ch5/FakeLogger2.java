package ch5;

public class FakeLogger2 implements ILogger {

    private String loggerGotMessage;
    public RuntimeException willThrow;

    @Override
    public void logError(String message) {
        loggerGotMessage = message;
        if (willThrow != null) {
            throw willThrow;
        }
    }

}

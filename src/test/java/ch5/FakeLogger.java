package ch5;

public class FakeLogger implements ILogger{

    public String lastError;
    @Override
    public void logError(String message) {
        lastError = message;
    }
}

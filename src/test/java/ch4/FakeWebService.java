package ch4;

public class FakeWebService implements IWebService{
    public String lastError;
    public RuntimeException toThrow;

    @Override
    public void LogError(String message) {
        lastError = message;

        if (toThrow!=null) {
            throw toThrow;
        }
    }
}

package ch5;

class FakeWebService implements IWebService {

    public String messageToWebService;


    public void write(String message) {
        messageToWebService = message;
    }


    public void write(ErrorInfo message) {
        messageToWebService = message.getMessage();
    }


}

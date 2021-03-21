package ch4;

public class LogAnalyzer {
    private IWebService service;

    public LogAnalyzer(IWebService service) {
        this.service = service;
    }

    public void Analyze(String fileName) {
        if (fileName.length() < 8) {
            service.LogError("Filename too short:" + fileName);
        }
    }
}

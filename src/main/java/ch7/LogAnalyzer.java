package ch7;

public class LogAnalyzer {

    public void analyze(String fileName) {
        if (fileName.length()<8) {
            LoggingFacility.log("Filename too short:" + fileName);
            throw new RuntimeException("Filename too short");
        }
    }

}

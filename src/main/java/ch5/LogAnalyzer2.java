package ch5;

import com.sun.javafx.binding.StringFormatter;

class LogAnalyzer2 {
    private IWebService service;
    private ILogger logger;

    public int getMinNameLength() {
        return minNameLength;
    }

    public void setMinNameLength(int minNameLength) {
        this.minNameLength = minNameLength;
    }

    private int minNameLength;

    public  LogAnalyzer2(ILogger logger, IWebService service) {
        this.logger = logger;
        this.service = service;
    }

    public void analyze2(String fileName) {
        if (fileName.length() < minNameLength) {
            try {
                logger.logError(String.format("Filename too short: %s", fileName));
            } catch (Exception e) {
                service.write(new ErrorInfo(1000, e.getMessage()));
            }
        }
    }

    public void analyze(String fileName) {
        if (fileName.length() < minNameLength) {
            try {
                logger.logError(String.format("Filename too short: %s", fileName));
            } catch (Exception e) {
                service.write("Error From Logger: " + e);
            }
        }
    }

    public IWebService getService() {
        return service;
    }

    public void setService(IWebService service) {
        this.service = service;
    }

}



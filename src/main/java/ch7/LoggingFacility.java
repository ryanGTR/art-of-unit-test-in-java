package ch7;


public class LoggingFacility {

    public static ILogger logger;

    public static ILogger getLogger() {
        return logger;
    }

    public static void log(String text) {
        logger.log(text);
    }

    public static void setLogger(ILogger logger) {
        LoggingFacility.logger = logger;
    }
}

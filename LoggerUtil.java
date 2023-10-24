import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {
    private static Logger logger;

    static {
        try {
            // Create a logger instance
            logger = Logger.getLogger(LoggerUtil.class.getName());

            // Configure logger to write to a file
            FileHandler fileHandler = new FileHandler("app.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);

            // Set the default log level (INFO)
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setLogLevel(Level level) {
        logger.setLevel(level);
    }

    public static void info(String message) {
        logger.log(Level.INFO, message);
    }

    public static void warning(String message) {
        logger.log(Level.WARNING, message);
    }

    public static void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void error(String message, Object additionalInfo) {
        logger.log(Level.SEVERE, message + " Additional Info: " + additionalInfo.toString());
    }

    public static void main(String[] args) {
        // Example usage of the LoggerUtil class
        LoggerUtil.info("Application started.");
        // Your application code here
        LoggerUtil.warning("Something unexpected happened.");
        // More code
        LoggerUtil.error("An error occurred.");
        // More code
        LoggerUtil.error("Another error occurred.", "Details: some additional information");
    }
}

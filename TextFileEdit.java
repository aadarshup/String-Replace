import java.io.*;
import java.util.regex.*;
import java.util.Properties;

public class TextFileEdit {
        public static void main(String[] args) {
            LoggerUtil.info("Application started.");
            Properties properties = new Properties();
            LoggerUtil.info("Reading config file...");
            try (FileInputStream input = new FileInputStream("config.properties")) {
                properties.load(input);
                // Define the file path
                LoggerUtil.info("Checking if input file path exists along with file name...");
                String filePath = properties.getProperty("FILE_PATH");

                // Define the string to be replaced and the replacement string
                LoggerUtil.info("Reading the target string given in config file...");
                String targetString = "\\b"+properties.getProperty("OLD_STRING_TO_REPLACE")+"\\b";  // Use "\\b" to match word boundaries
                LoggerUtil.info("Reading the new string to replace the older one from config file...");
                String replacementString = properties.getProperty("NEW_STRING_TO_PLACE");

                // Read the content of the file into memory
                LoggerUtil.info("Loading file content in memory and reading the contents...");
                StringBuilder content = new StringBuilder();
                try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        content.append(line).append(System.lineSeparator());
                    }
                } catch (IOException e) {
                    // e.printStackTrace();
                    LoggerUtil.error("Unable to load and read file in memory", e);
                    return;
                }

                // Perform the replacement in a case-insensitive and word-boundary manner
                LoggerUtil.info("Making string case insensitive and replacing with new given string...");
                String modifiedContent = Pattern.compile(targetString, Pattern.CASE_INSENSITIVE)
                        .matcher(content.toString())
                        .replaceAll(Matcher.quoteReplacement(replacementString));

                // Write the modified content back to the original file
                LoggerUtil.info("Replacement of string done, now modifying the original file...");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                    writer.write(modifiedContent);
                    System.out.println("String replaced successfully.");
                } catch (IOException e) {
                    // e.printStackTrace();
                    LoggerUtil.error("Error occurred while writing into original file...",e);
                }
            }
            catch (IOException e) {
                // e.printStackTrace();
                LoggerUtil.error("Error occurred while reading config file", e);
        }
    }
}




/*import java.io.*;

public class TextFileEdit {
    public static void main(String[] args) {
        // Define the file path
        String filePath = "C:\\Users\\prans\\JavaProjects\\sample.txt";

        // Define the string to be replaced and the replacement string
        String targetString = " Success ";
        String replacementString = " Winner ";

        // Read the content of the file into memory
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Perform the replacement in a case-insensitive manner
        String modifiedContent = content.toString().replaceAll("(?i)" + targetString, replacementString);

        // Write the modified content back to the original file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(modifiedContent);
            System.out.println("String replaced successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
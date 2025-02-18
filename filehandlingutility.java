import java.io.*;
import java.nio.file.*;

public class FileUtility {

    // Write content to a file
    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read content from a file
    public static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return content.toString();
    }

    // Append content to a file
    public static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Content appended successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }

    // Delete a file
    public static void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
            System.out.println("File deleted successfully.");
        } catch (IOException e) {
            System.out.println("Error deleting file: " + e.getMessage());
        }
    }

    // Main method to test the utility
    public static void main(String[] args) {
        String filePath = "testfile.txt";

        writeToFile(filePath, "Hello, this is a test file!");
        System.out.println("File Content:\n" + readFromFile(filePath));

        appendToFile(filePath, "\nAppending new content...");
        System.out.println("Updated File Content:\n" + readFromFile(filePath));

        deleteFile(filePath);
    }
}

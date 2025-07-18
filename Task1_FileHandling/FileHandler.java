import java.io.*;
import java.util.*;

public class FileHandler {

    // File path (you can customize)
    static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        try {
            // Step 1: Write to file
            writeFile("Hello, this is a Java File Handling Task.\nLet's modify this content later.");

            // Step 2: Read file
            System.out.println("Original File Content:");
            readFile();

            // Step 3: Modify file content
            modifyFile("Java", "Awesome Java");

            // Step 4: Read file after modification
            System.out.println("\nModified File Content:");
            readFile();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    // Method to write content to file
    static void writeFile(String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write(content);
        writer.close();
    }

    // Method to read and print file content
    static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    // Method to modify content in file
    static void modifyFile(String oldWord, String newWord) throws IOException {
        File file = new File(FILE_NAME);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line.replaceAll(oldWord, newWord)).append("\n");
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(content.toString());
        writer.close();
    }
}

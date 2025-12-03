import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    // Reads a file and returns an array of strings
    public static String[] readFileIntoArray(String filePath) throws IOException {
        // Check if the file exists
        if (!Files.exists(Paths.get(filePath))) {
            throw new IOException("File not found: " + filePath);
        }
        // Use a list to store lines temporarily
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines.toArray(new String[0]); // Convert list to array and return it
    }

    // Main method for testing
    public static void main(String[] args) {
        // Define the file path
        String filePath = "sample.txt"; // Replace with your file's path

        try {
            // Read the file into an array
            String[] lines = readFileIntoArray(filePath);

            // Print the result
            System.out.println("Contents of the file:");
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

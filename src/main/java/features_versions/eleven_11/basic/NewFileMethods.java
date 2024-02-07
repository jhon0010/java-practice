package features_versions.eleven_11.basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Files.writeString(Path, CharSequence): This method writes a CharSequence (such as a String) to a file.
 * The method creates the file if it doesn't exist or overwrites the file if it already exists. In this example,
 * contentToWrite is written to example.txt.
 * Files.readString(Path): This method reads all content from a file into a String. It's a convenient way to quickly
 * read file content without the need for manual buffering or looping through lines of the file. In this example, the
 * content of example.txt is read back into contentRead.
 */
public class NewFileMethods {

    public static void main(String[] args) {

        // Define the path to the file
        Path filePath = Path.of("example.txt");

        // The content to write to the file
        String contentToWrite = "Hello, Java 11 File API!";

        try {
            // Write the string to the file
            Files.writeString(filePath, contentToWrite);
            System.out.println("Content written to file.");

            // Read the string from the file
            String contentRead = Files.readString(filePath);
            System.out.println("Content read from file: " + contentRead);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

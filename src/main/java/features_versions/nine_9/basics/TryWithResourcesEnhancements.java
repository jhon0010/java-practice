package features_versions.nine_9.basics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Java 9 made the syntax more flexible by allowing you to use final or effectively final resources within
 * try-with-resources statements without redeclaring them. This means you can now directly pass existing resources that
 * are declared outside the try block, reducing verbosity and improving code readability.
 */
public class TryWithResourcesEnhancements {

    public static void main(String[] args) throws IOException {

        // before java 9
        BufferedReader reader = new BufferedReader(new FileReader("path/to/file.txt"));
        try (BufferedReader r = reader) { // YOU HAVE TO DECLARE THE RESOURCE AGAIN IN THE TRY BLOCK
            // Use the resource r
        }

        // after java 9
        BufferedReader reader9 = new BufferedReader(new FileReader("path/to/file.txt"));
        try (reader9) { // YOU CAN USE THE RESOURCE DIRECTLY IN THE TRY BLOCK
            // Use the resource
        }

    }

}

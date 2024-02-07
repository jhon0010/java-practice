package features_versions.eleven_11.basic;

/**
 * New String methods in Java 11, those include:
 *  - isBlank() : checks if the string is empty or contains only white spaces
 *  - lines() : returns a stream of lines extracted from the string
 *  - repeat(int) : returns a string whose value is the concatenation of the original string repeated n times
 *  - strip() : returns a string whose value is this string, with all leading and trailing white space removed
 *  - stripLeading() : returns a string whose value is this string, with all leading white space removed
 *  - stripTrailing() : returns a string whose value is this string, with all trailing white space removed
 */
public class NewStringMethods {

    public static void main(String[] args) {

        // Example string
        String example = "  Hello, Java 11!  \nThis is a new line.\n";

        // isBlank() example
        String blank = "  ";
        System.out.println("Is the string blank? " + blank.isBlank()); // true

        // lines() example
        System.out.println("Lines from the string:");
        example.lines().forEach(System.out::println);

        // repeat(int) example
        String repeat = "Java ";
        System.out.println("Repeating string: " + repeat.repeat(3)); // Java Java Java

        // strip(), stripLeading(), stripTrailing() example
        System.out.println("Original string: '" + example + "'");
        System.out.println("Stripped string: '" + example.strip() + "'");
        System.out.println("Leading stripped string: '" + example.stripLeading() + "'");
        System.out.println("Trailing stripped string: '" + example.stripTrailing() + "'");

    }

}

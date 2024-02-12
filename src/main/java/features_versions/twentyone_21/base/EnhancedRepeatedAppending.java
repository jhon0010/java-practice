package features_versions.twentyone_21.base;

/**
 * JDK 21 has added methods to ‘java.lang.StringBuilder’ and ‘java.lang.StringBuffer’.
 * The int codePoint method adds the same character multiple times to StringBuilder or StringBuffer using its Unicode number.
 *
 * Use it instead of using loops to append the repeated characters or sequences.
 */
public class EnhancedRepeatedAppending {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();

        // Using unicode code point
        sb1.repeat(42, 10); // Appends "**********" to sb1
        System.out.println(sb1);

        // Using a sequence of characters
        StringBuilder sb2 = new StringBuilder();
        sb2.repeat("-=", 20); // Appends "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=" to sb2
        System.out.println(sb2);
    }
}

package features_versions.fourteen_14.basics;

/**
 * PatternMatching Instanceof allows you to declare a new variable in the same line as the instanceof operator and use it.
 */
public class PatternMatchingInstanceof {

    public static void main(String[] args) {

        // Before Java 14
        Object obj = "Hello";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s);
        }
        // The above code can be replaced with the following code
        if (obj instanceof String s) {
            System.out.println(s);
        }
    }

}

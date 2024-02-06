package features_versions.nine_9.basics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Before Java 9
 * Prior to Java 9, when you wanted to create an instance of an anonymous inner class with generic type parameters,
 * you had to specify the type parameters explicitly, even though they could be inferred from the context.
 * This requirement was due to the compiler's inability to infer type arguments for anonymous inner classes using the
 * diamond operator.
 *
 * Java 9 Enhancement
 * Java 9 enhances the diamond operator by allowing it to be used with anonymous inner classes under certain conditions.
 * This change further reduces the verbosity of the code and makes it more readable. The compiler can now infer the type
 * parameters of an anonymous inner class when the type argument is denotable or inferable from the context.
 */
public class DiamondOperatorEnhancements {

    public static void main(String[] args) {

        // Before Java 9
        Map<String, List<String>> myMap = new HashMap<String, List<String>>() {
            // Anonymous inner class with explicit type parameters
        };

        // In Java 9
        Map<String, List<String>> myMap2 = new HashMap<>() {
            // Anonymous inner class with diamond operator
        };
    }

}

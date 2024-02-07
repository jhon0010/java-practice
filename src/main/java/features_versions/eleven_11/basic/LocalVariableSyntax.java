package features_versions.eleven_11.basic;

import java.util.function.BiFunction;

/**
 * Local variable syntax for lambda parameters in Java 11.
 */
public class LocalVariableSyntax {

    public static void main(String[] args) {

        // Without 'var': Implicit type inference
        BiFunction<String, String, String> concatWithoutVar = (s1, s2) -> s1 + s2;
        System.out.println(concatWithoutVar.apply("Hello, ", "Java 10!"));

        // With 'var': Explicit type inference
        BiFunction<String, String, String> concatWithVar = (var s1, var s2) -> s1 + s2;
        System.out.println(concatWithVar.apply("Hello, ", "Java 11!"));

        // Using 'var' with type annotations (e.g., @NonNull)
        // Note: This requires a non-null annotation definition in your project.
        // BiFunction<String, String, String> concatWithAnnotations = (@NonNull var s1, @NonNull var s2) -> s1 + s2;
        // System.out.println(concatWithAnnotations.apply("Hello, ", "Java 11 with annotations!"));

    }

}

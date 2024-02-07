package features_versions.eleven_11.basic;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Java 11 introduced several enhancements to the Optional class, making it more powerful and convenient for handling
 * optional values.
 * These enhancements improve the expressiveness and readability of your code.
 */
public class OptionalEnhancements {

    public static void main(String[] args) {
        OptionalIsEmpty();
        OptionalOr();
        OptionalStream();
    }

    /**
     * Before Java 11, to check if an Optional object does not contain a value, you had to use !optional.isPresent().
     * Java 11 introduced the isEmpty() method, which is more readable and directly conveys the intention.
     */
    public static void OptionalIsEmpty() {

        Optional<String> optional = Optional.empty();
        if (!optional.isPresent()) {
            System.out.println("Optional is empty");
        }

        Optional<String> optional11 = Optional.empty();
        if (optional.isEmpty()) {
            System.out.println("Optional is empty");
        }
    }

    /**
     * The or() method provides a way to lazily provide an alternative Optional object if the original Optional is empty.
     * This is particularly useful for providing default values or fallbacks.
     */
    public static void OptionalOr() {
        Optional<String> optional = Optional.empty();
        // Java 11 allows chaining of optionals in a more fluent way
        Optional<String> result = optional.or(() -> Optional.of("Default Value"));
        System.out.println(result.get()); // Outputs: Default Value
    }

    /**
     * Java 9 introduced stream() to Optional, allowing an Optional to be turned into a Stream of either zero or one elements.
     * However, it's worth mentioning here due to its utility alongside Java 11 improvements.
     * This can be particularly useful when you want to chain stream operations on an Optional value.
     */
    public static void OptionalStream() {
        Optional<String> optional = Optional.of("Hello, World!");

        List<String> result = optional.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(result); // Outputs: [HELLO, WORLD!]
    }

}

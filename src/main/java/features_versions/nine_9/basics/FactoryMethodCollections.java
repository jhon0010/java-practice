package features_versions.nine_9.basics;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Java 9 introduced convenient factory methods for creating immutable collections. These methods make it easier and more
 * concise to create lists, sets, and maps without needing to create mutable collections and then wrapping them with Collections.
 * unmodifiableXXX methods. This feature helps to reduce boilerplate code and makes the code more readable and efficient.
 */
public class FactoryMethodCollections {

    /**
     * Characteristics of Collections Created with Factory Methods:
     *
     * Immutable: Collections created with these factory methods are immutable. Any attempt to modify them (add, remove, or change elements) will result in UnsupportedOperationException.
     * Null Elements and Keys: These collections do not allow null elements or keys. Attempting to create collections with null values will result in NullPointerException.
     * Serialization: These collections are serializable if all their elements are serializable.
     * Performance: These collections are likely to be more performance-optimized compared to collections created and then wrapped as unmodifiable.
     *
     */
    public static void main(String[] args) {

        List<String> immutableList = List.of("Java", "Python", "JavaScript");
        Set<String> immutableSet = Set.of("Java", "Python", "JavaScript");
        Map<String, String> immutableMap = Map.of("Java", "8", "Python", "3", "JavaScript", "ES6");

        // For more than 10 key-value pairs or when key-value pairs are generated programmatically
        Map<String, Integer> anotherImmutableMap = Map.ofEntries(
                Map.entry("Java", 8),
                Map.entry("Python", 3),
                Map.entry("JavaScript", 1)
        );

    }

}

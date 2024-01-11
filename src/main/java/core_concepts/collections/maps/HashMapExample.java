package core_concepts.collections.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Example of using HashMap in Java.
 *
 * HashMap is a hash table based implementation of the Map interface. It allows null values and one null key.
 * It does not guarantee the order of elements. HashMap is not synchronized and should be used with caution in multi-threaded environments.
 * For a synchronized version, consider using Collections.synchronizedMap() or ConcurrentHashMap.
 */
public class HashMapExample {

    public static void main(String[] args) {

        // Create a HashMap with Integer keys and String values
        Map<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the map
        map.put(10, "Ten");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(50, "Fifty");
        map.put(3, "Three");

        // Retrieve values using keys
        System.out.println("Value for key 2: " + map.get(2));  // "Two"

        // Check if a key exists
        System.out.println("Does key 4 exist? " + map.containsKey(4));  // false

        // Demonstrate the use of one null key
        map.put(null, "Null Key Value");
        System.out.println("Value for null key: " + map.get(null));

        // Iterate through the map using forEach (Java 8 feature)
        map.forEach((key, value) -> System.out.println(key + ": " + value));

        // Replace all values in the map
        map.replaceAll((k, v) -> "Number: " + v);
        System.out.println("Value for key 2 after replaceAll: " + map.get(2));

        // Demonstrate removal of a key-value pair
        map.remove(10);
        System.out.println("Is key 10 present after removal? " + map.containsKey(10));

        // Print the size of the map
        System.out.println("Size of map: " + map.size());

        // Clear the map
        map.clear();
        System.out.println("Is the map empty after clear? " + map.isEmpty());
    }
}


package practice.collections.maps;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMap is a class that implements the Map interface, which uses a hash table for storage.
 * When we say that LinkedHashMap is a "map", we mean that it cannot contain duplicate keys.
 * Objects that are stored in a LinkedHashMap are stored in insertion order.
 * Allow one null key.
 */
public class LinkedHashMapExample {

    public static void main(String[] args) {
        // Create a LinkedHashMap with insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Add key-value pairs
        linkedHashMap.put("apple", 5);
        linkedHashMap.put("banana", 3);
        linkedHashMap.put("cherry", 7);

        linkedHashMap.put(null, 0); // Allow one null key

        // Iterate through the elements in insertion order
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

package core_concepts.collections.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Similar to HashTable but is not synchronized.
 *
 * HashMap is a hash table based implementation of the Map interface. It permits null values and ONE null key.
 * This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will.
 * The key is hashed, and the resulting hash code is used as the index at which the value is stored within the table,
 * internally this used an array of buckets for Entry objects and the hash defines which one to use.
 *
 * It's a concrete extended version of AbstractMap.
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
        System.out.println(map.get(2));  // "Two"

        // Check if a key exists
        System.out.println(map.containsKey(4));  // false

        // One null key is allowed
        map.put(null, "Only One Null is Allow it");

        // Iterate through the map
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // replace all values example
        map.replaceAll((k, v) -> "Mr. " + v);
        System.out.println(map.get(2));

    }

}

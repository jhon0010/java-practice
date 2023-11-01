package practice.collections.maps;

import java.util.Hashtable;
import java.util.Map;

/**
 * Synchronized, you can use it in a multithreaded environment without any issues.
 *
 * Hashtable is a hash table based implementation of the Map interface. It permits null values and ONE null key.
 *     This class makes no guarantees as to the order of the map; in particular, it does not guarantee that the order will.
 *
 *  It's a concrete extended version of AbstractMap.
 */
public class HashTableExample {

    public static void main(String[] args) {

        // Create a Hashtable with Integer keys and String values
        Map<Integer, String> hashtable = new Hashtable<>();

        // Add key-value pairs to the hashtable
        hashtable.put(1, "One");
        hashtable.put(2, "Two");
        hashtable.put(3, "Three");

        // Retrieve values using keys
        System.out.println(hashtable.get(2));  // "Two"

        // Check if a key exists
        System.out.println(hashtable.containsKey(4));  // false

        // Iterate through the hashtable
        for (Integer key : hashtable.keySet()) {
            System.out.println(key + ": " + hashtable.get(key));
        }

        try {
            hashtable.put(null, "Four");
        } catch (NullPointerException e) {
            System.out.println("NullPointerException = Null key not allowed on Hashtable");
        }
    }
}

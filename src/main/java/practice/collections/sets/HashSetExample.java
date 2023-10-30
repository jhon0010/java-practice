package practice.collections.sets;

import java.util.HashSet;

/**
 * HashSet is a class that implements the Set interface, which uses a hash table for storage.
 * When we say that HashSet is a "set", we mean that it cannot contain duplicate elements.
 * Objects that are stored in a HashSet are stored in no particular order.
 * Allow one null element.
 * It's the fastest implementation of Set because of the hashing mechanism, accessing time is O(1).
 */
public class HashSetExample {

    public static void main(String[] args) {

        HashSet<String> fruits = new HashSet<>();

        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");
        fruits.add("date");
        fruits.add("apple"); // Duplicate, will not be added

        // allow one null element
        fruits.add(null);

        System.out.println("Fruits in the HashSet:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }

}

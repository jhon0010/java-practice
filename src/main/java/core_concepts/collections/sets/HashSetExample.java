package core_concepts.collections.sets;

import java.util.HashSet;

/**
 * Underlying Data Structure: HashSet is typically implemented using a hash table.
 * This data structure allows for efficient insertion, deletion, and retrieval of elements,
 * making HashSet suitable for scenarios where you need to quickly check for the existence of an element.
 *
 * HashSet is a class that implements the Set interface, which uses a hash table for storage.
 * When we say that HashSet is a "set", we mean that it cannot contain duplicate elements.
 * Objects that are stored in a HashSet are stored in no particular order.
 *
 * Not synchronized.
 *
 * Allow one null element.
 *
 * Performance: The average time complexity for common operations in a HashSet (such as add, remove, and contains)
 * is O(1), assuming a good hash function. This makes it very efficient for large sets.
 *
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

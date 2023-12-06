package core_concepts.collections.sets;

import java.util.LinkedHashSet;

/**
 *
 * It combines the features of a HashSet and a LinkedHashMap,
 * offering a collection of unique elements with predictable iteration order.
 *
 * LinkedHashSet is a class that implements the Set interface, which uses a hash table for storage.
 * When we say that LinkedHashSet is a "set", we mean that it cannot contain duplicate elements.
 * Objects that are stored in a LinkedHashSet are stored in insertion order.
 * Allow one null element.
 * It's the fastest implementation of Set because of the hashing mechanism, accessing time is O(1).
 */
public class LinkedHashSetExample {

    public static void main(String[] args) {

        LinkedHashSet<String> colors = new LinkedHashSet<>();

        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("red"); // Duplicate, will not be added

        colors.add(null); // Allow one null element

        System.out.println("Colors in the LinkedHashSet:");
        for (String color : colors) {
            System.out.println(color);
        }
    }

}

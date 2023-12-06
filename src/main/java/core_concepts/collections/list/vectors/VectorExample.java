package core_concepts.collections.list.vectors;

import java.util.List;
import java.util.Vector;

/**
 * Extends from List.
 *
 * Vector is a legacy collection class in Java that is part of the Java Collections Framework. It is similar to an
 * ArrayList in that it is a dynamic array that can grow or shrink in size.
 *
 * Vector is considered a legacy class
 *
 * Vector is that it is synchronized (is thread-safe) compare with list is not. But in modern Java, you might prefer using other thread-safe
 * collections, such as CopyOnWriteArrayList
 */
public class VectorExample {

    public static void main(String[] args) {
        // Create a Vector of integers
        List<Integer> vector = new Vector<>();

        // Add elements to the Vector
        vector.add(1);
        vector.add(2);
        vector.add(3);

        // Access elements by index
        int element = vector.get(1);
        System.out.println("Element at index 1: " + element);

        // Remove an element
        vector.remove(0);

        // Iterate over the elements
        for (Integer num : vector) {
            System.out.println("Element: " + num);
        }
    }
}

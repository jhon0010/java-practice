package core_concepts.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Allow random access because array works at the index basis.
 * Allow duplicate elements.
 * Maintains the order in which elements are inserted.
 * Not synchronized.
 */
public class ArrayListExample {

    public static void main(String[] args) {
        // Creating an ArrayList of integers
        List<Integer> numbers = new ArrayList<>();

        // Adding elements to the list
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(20);
        numbers.add(40);

        // Accessing elements by index
        int firstNumber = numbers.get(0);
        System.out.println("First number: " + firstNumber);

        // Iterating over the list
        for (int number : numbers) {
            System.out.println(number);
        }

        // Removing an element
        numbers.remove(1); // Removes the element at index 1

        // Size of the list
        System.out.println("Number of elements: " + numbers.size());
    }

}

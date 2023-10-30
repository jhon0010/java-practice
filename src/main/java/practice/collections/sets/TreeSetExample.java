package practice.collections.sets;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet is a class that implements the Set interface, which uses a tree for storage.
 * Objects are stored in sorted, ascending order.
 * Access and retrieval times are quite fast, which makes TreeSet an excellent choice when storing large amounts of
 * sorted information that must be found quickly.
 *  <p>
 *      It is an implementation of SortedSet interface.
 */
public class TreeSetExample {

    public static void main(String[] args) {

        customComparator(args);

        TreeSet<Integer> numbers = new TreeSet<>();

        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        System.out.println("Sorted Numbers:");
        for (Integer number : numbers) {
            System.out.println(number);
        }

        try {
            numbers.add(null);
        } catch (NullPointerException e) {
            System.out.println("TreeSet doesn't allow null values");
        }

    }

    /**
     * Custom comparator implementation for TreeSet.
     * Use the length of the string to sort the words.
     * @param args arguments
     */
    public static void customComparator(String[] args) {
        TreeSet<String> words = new TreeSet<>(Comparator.comparing(String::length));

        words.add("apple");
        words.add("banana");
        words.add("cherry");
        words.add("date");

        System.out.println("Sorted Words by Length:");
        for (String word : words) {
            System.out.println(word);
        }
    }

}

package practice.collections.maps;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeSet;

/**
 * TreeMap is a Red-Black tree based NavigableMap implementation from NavigableMap interface that extends from SortedMap.
 * The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time,
 * depending on which constructor is used.
 * This implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
 */
public class TreeMapExample {

    public static void main(String[] args) {

        customComparator(args);

        NavigableMap<String, Integer> ageMap = new java.util.TreeMap<>();
        //SortedMap<String, Integer> ageMap = new java.util.TreeMap<>();
        ageMap.put("Zuly", 20);
        ageMap.put("Jhon", 30);
        ageMap.put("Alice", 31);
        ageMap.put("Bob", 32);
        ageMap.put("Charlie", 33);

        for(String key : ageMap.keySet()) {
            System.out.println("Key: " + key + " Value: " + ageMap.get(key));
        }

        // Retrieve a sub-map for keys within the range ["Alice", "Charlie"]
        SortedMap<String, Integer> subMap = ageMap.subMap("Alice", "Charlie");
        System.out.println(subMap);

        // headMap and tailMap are similar to subMap, except that they include the start and end keys
        SortedMap<String, Integer> headMap = ageMap.headMap("Charlie");
        System.out.println(headMap);

        SortedMap<String, Integer> tailMap = ageMap.tailMap("Charlie");
        System.out.println(tailMap);
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

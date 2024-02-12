package features_versions.twentyone_21.base;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.SequencedCollection;

/**
 * The SequencedCollection interface is a new interface in Java 21 that extends the Collection interface.
 * It provides a way to access elements in the order they were added to the collection.
 * The new methods in the SequencedCollection interface are:
 * - addFirst(E e)
 * - addLast(E e)
 * - getFirst()
 * - getLast()
 * - reversed()
 * - removeFirst()
 * - removeLast()
 * - setFirst(E e)
 * - setLast(E e)
 */
public class SequencedCollectionExamples {

    public static void main(String[] args) {
        SequencedCollection<String> languages = LinkedHashSet.newLinkedHashSet(10);
        languages.add("English");
        languages.add("Spanish");
        languages.add("French");
        languages.add("Italian");
        languages.addFirst("Portuguese");

        System.out.println(STR."First lengage = \{languages.getFirst()}");
        System.out.println(STR."Last lengage = \{languages.getLast()}");

        languages.containsAll(List.of("Portuguese", "English", "Spanish", "French", "Italian"));

        SequencedCollection<String> reversed = languages.reversed();
        boolean containsAll = reversed.containsAll(List.of("Italian", "French", "Spanish", "English", "Portuguese"));
        System.out.println(STR."Reversed contains all = \{containsAll}");
    }

}

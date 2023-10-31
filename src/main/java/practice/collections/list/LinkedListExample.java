package practice.collections.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedList is a doubly linked list implementation of the List and Deque interfaces.
 * Internally, it uses a doubly linked list to store the elements.
 * Compared to ArrayList, LinkedList has better add and remove performance as it involves
 *
 * In oder to traverse the list using next() and previous() methods, we need to use ListIterator.
 *
 * There is NO concrete implementation of singly linked list in Java.
 */
public class LinkedListExample {

    public static void main(String[] args) {
        List<Integer> doublyLinkedList = new LinkedList<>();

        // Appending elements to the doubly linked list
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);

        // Traversing the list forward
        System.out.println("Forward traversal:");
        for (Integer element : doublyLinkedList) {
            System.out.print(element + " ");
        }

        // Traversing the list forward using iterator
        System.out.println("\nForward traversal using iterator:");
        ListIterator<Integer> iterator = doublyLinkedList.listIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        // Traversing the list backward
        System.out.println("Backward traversal:");
        ListIterator<Integer> listIterator = doublyLinkedList.listIterator(doublyLinkedList.size());
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }

}

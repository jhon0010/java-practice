package practice.collections.queus;

import java.util.ArrayDeque;

/**
 * ArrayDeque is a resizable array implementation of the Deque interface.
 * Array deques have no capacity restrictions and they grow as necessary to support usage.
 * They are not thread-safe which means that in the absence of external synchronization,
 *
 * You can put and get elements to the beginning and end of the ArrayDeque.
 * Making it a double ended queue that means can act as a
 * FIFO (First In First Out) queue or a LIFO (Last In First Out) stack.
 */
public class ArrayDequeExample {

    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();

        stack.push("First");
        stack.push("Second");
        stack.push("Third");
        stack.push("Fourth");
        stack.push("Fifth");

        // get first element
        System.out.println("First element: " + stack.getFirst());

        // get last element
        System.out.println("Last element: " + stack.getLast());

        // add element to the beginning
        stack.addFirst("Sixth");
        System.out.println("Peeked added: " + stack.peek());

        // add element to the end
        stack.addLast("Seventh");
        System.out.println("Get added at the end : " + stack.getLast());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
    }

}

package practice.collections.queus;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue is a FIFO (First In First Out) data structure.
 * In a FIFO data structure, the first element added to the queue will be the first one to be removed.
 *
 * To use a linked list as a queue, we must use the offer() and poll() methods.
 */
public class LinkedListAsQueueExample {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        // Enqueue elements
        queue.offer("First");
        queue.offer("Second");
        queue.offer("Third");

        // Peek the head of the queue without removing it
        String peeked = queue.peek(); // return the head of the queue, or null if the queue is empty.
        System.out.println("Peeked: " + peeked);

        // Dequeue and process elements
        while (!queue.isEmpty()) {
            String element = queue.poll();
            System.out.println("Dequeued: " + element);
        }
    }

}

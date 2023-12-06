package core_concepts.collections.queus;

import java.util.PriorityQueue;

/**
 * PriorityQueue is an unbounded queue based on a priority heap and the elements are ordered by their natural ordering,
 * or by a Comparator provided at queue construction time, depending on which constructor is used.
 * A priority queue does not permit null elements.
 * A priority queue relying on natural ordering also does not permit insertion of non-comparable objects
 *
 */
public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        addElementsToQueue(priorityQueue);
        printQueue(priorityQueue);


        PriorityQueue<Integer> customOrderQueue = new PriorityQueue<>((a, b) -> b.compareTo(a)); // Reverse order
        addElementsToQueue(customOrderQueue);
        printQueue(customOrderQueue);
    }

    private static void addElementsToQueue(PriorityQueue<Integer> priorityQueue) {
        priorityQueue.offer(100);
        priorityQueue.offer(3);
        priorityQueue.offer(70);
        priorityQueue.offer(1);
        priorityQueue.offer(20);
        priorityQueue.offer(2);
    }

    private static void printQueue(PriorityQueue<Integer> priorityQueue) {
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

}

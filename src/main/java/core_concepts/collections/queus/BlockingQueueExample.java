package core_concepts.collections.queus;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * A BlockingQueue is a specialized type of queue in Java that provides additional methods for handling cases where the
 * queue is empty or full. It's typically used in multi-threaded applications where one thread produces data and
 * another thread consumes it. The main feature of a BlockingQueue is its ability to block (i.e., pause) the threads
 * trying to either enqueue data (when the queue is full) or dequeue data (when the queue is empty) until the required
 * conditions are met.
 *
 * BlockingQueue implementations are thread-safe. All queuing methods achieve their effects atomically using internal
 */
public class BlockingQueueExample {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>(3);

        // Producer thread
        new Thread(() -> {
            try {
                queue.put(1);
                queue.put(2);
                queue.put(3);
                System.out.println("Produced 3 items");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();

        // Consumer thread
        new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some work before consuming
                System.out.println("Consumed: " + queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }

    public static void arrayBlockingQueue(String[] args) {
        // Create a blocking queue with a capacity of 2
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                queue.put(1); // Add an element to the queue
                System.out.println("Produced: 1");
                queue.put(2); // Add another element to the queue
                System.out.println("Produced: 2");
                queue.put(3); // This will block the producer because the queue is full
                System.out.println("Produced: 3"); // This line won't be reached
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some work before consuming
                System.out.println("Consumed: " + queue.take()); // Consume an element
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }

}

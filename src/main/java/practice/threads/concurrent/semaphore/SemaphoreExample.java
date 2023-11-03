package practice.threads.concurrent.semaphore;

import practice.threads.common.SharedResource;

import java.util.concurrent.Semaphore;

/**
 * In contrast with the RaceCondition example, here we're using a semaphore to synchronize the access to a shared resource.
 * Resulting in a predictable behaviour.
 *
 * The semaphore is a technique used to control access to a shared resource by multiple threads.
 *
 */
public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {

        // creating a Semaphore object
        // with number of permits threads is  1
        Semaphore sem = new Semaphore(1);

        // creating two threads with name A and B
        // Note that thread A will increment the count
        // and thread B will decrement the count
        ThreadWithSemaphore tfr1 = new ThreadWithSemaphore(sem, "A");
        ThreadWithSemaphore tfr2 = new ThreadWithSemaphore(sem, "B");

        // stating threads A and B
        tfr1.start();
        tfr2.start();

        // waiting for threads A and B
        tfr1.join();
        tfr2.join();

        // count will always remain 0 after
        // both threads will complete their execution
        System.out.println("count: " + SharedResource.count);

        /**
         * Output example:
         *
         * Starting A
         * Starting B
         * A is waiting for a permit.
         * A gets a permit.
         * B is waiting for a permit.
         * A: 1
         * A: 2
         * A: 3
         * A: 4
         * A: 5
         * A releases the permit.
         * B gets a permit.
         * B: 4
         * B: 3
         * B: 2
         * B: 1
         * B: 0
         * B releases the permit.
         * count: 0
         *
         */

    }
}

package core_concepts.threads.concurrent.semaphore;

import core_concepts.threads.common.SharedResource;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Thread that uses a semaphore in order to synchronize the access to a shared resource and avoid race conditions.
 *
 * This is a thread that allow us to modify a shared resource.
 * If thread name starts by "A", it will increment the shared resource.
 * If thread name starts by "B", it will decrement the shared resource.
 * <p>
 *     They're allowing a context switch -- if possible, Using:
 *                     Thread.sleep(randomInt);
 */
public class ThreadWithSemaphore extends Thread {

    Semaphore semaphore;
    String threadName;

    public ThreadWithSemaphore(Semaphore sem, String threadName) {
        super(threadName);
        this.semaphore = sem;
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run by thread A
        if (this.getName().equals("A")) {
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");

                // acquiring the lock
                semaphore.acquire();

                System.out.println(threadName + " gets a permit.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedResource.count++;
                    System.out.println(threadName + ": " + SharedResource.count);

                    int random = new Random().nextInt(100);

                    // Now, allowing a context switch -- if possible.
                    // for thread B to execute
                    Thread.sleep(random);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            semaphore.release();
        }

        // run by thread B
        else {
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");

                // acquiring the lock
                semaphore.acquire();

                System.out.println(threadName + " gets a permit.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedResource.count--;
                    System.out.println(threadName + ": " + SharedResource.count);


                    int random = new Random().nextInt(100);

                    // Now, allowing a context switch -- if possible.
                    // for thread A to execute
                    Thread.sleep(random);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Release the permit.
            System.out.println(threadName + " releases the permit.");
            semaphore.release();
        }

    }


}

package core_concepts.threads.racecondition;

import core_concepts.threads.common.SharedResource;

import java.util.Random;

/**
 * This thread allow us to modify a shared resource:
 *  If thread name starts by "A", it will increment the shared resource.
 *  If thread name starts by "B", it will decrement the shared resource.
 *  <p>
 *
 */
public class ThreadRaceCondition extends Thread {

    String threadName;

    public ThreadRaceCondition(String threadName) {
        super(threadName);
        this.threadName = threadName;
    }

    @Override
    public void run() {

        // run by thread A
        if (this.getName().equals("A")) {
            System.out.println("Starting " + threadName);
            try {
                // First, get a permit.
                System.out.println(threadName + " starts.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedResource.count++;
                    System.out.println(threadName + ": " + SharedResource.count);

                    // Now, allowing a context switch -- if possible.
                    // for thread B to execute
                    int random = new Random().nextInt(100);
                    Thread.sleep(random);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }

            System.out.println(threadName + " finished.");
        }

        // run by thread B
        else {
            System.out.println("Starting " + threadName);
            try {

                System.out.println(threadName + " starts.");

                // Now, accessing the shared resource.
                // other waiting threads will wait, until this
                // thread release the lock
                for (int i = 0; i < 5; i++) {
                    SharedResource.count--;
                    System.out.println(threadName + ": " + SharedResource.count);

                    // Now, allowing a context switch -- if possible.
                    // for thread A to execute
                    int random = new Random().nextInt(100);
                    Thread.sleep(random);
                }
            } catch (InterruptedException exc) {
                System.out.println(exc);
            }
            // Release the permit.
            System.out.println(threadName + " finished.");
        }

    }


}

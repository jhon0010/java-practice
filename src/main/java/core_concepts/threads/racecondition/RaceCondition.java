package core_concepts.threads.racecondition;

import core_concepts.threads.common.SharedResource;

/**
 *  Here we could see how this experiment with only two threads and a shared resource has an
 *  unpredictable behaviour doing a simple task.
 *
 *  The race condition occurs when two or more threads can access shared data and they try to change it at the same time.
 *  Because the thread scheduling algorithm can swap between threads at any time, you don't know the order in which the
 *  threads will attempt to access the shared data. Therefore, the result of the change in data is dependent on the
 *  thread scheduling algorithm (often manage by the O.S.), i.e. both threads are "racing" to access/change the data.
 *
 *  Resulting in an unpredictable behaviour.
 *
 */
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {


        ThreadRaceCondition thread1 = new ThreadRaceCondition("A");
        ThreadRaceCondition thread2 = new ThreadRaceCondition("B");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Shared count: " + SharedResource.count);
    }

    // Output examples :

    /**
     * Starting A
     * Starting B
     * A starts.
     * B starts.
     * B: 0
     * A: 1
     * B: 1
     * A: 1
     * A: 1
     * B: 0
     * A: 2
     * B: 1
     * A: 1
     * B: 0
     * B finished.
     * A finished.
     * Shared count: 1
     */

    /**
     * Starting A
     * Starting B
     * A starts.
     * B starts.
     * A: 1
     * B: 0
     * A: 1
     * B: 0
     * A: 1
     * B: 0
     * A: 1
     * B: 0
     * A: 1
     * B: 0
     * B finished.
     * A finished.
     * Shared count: 0
     */

}

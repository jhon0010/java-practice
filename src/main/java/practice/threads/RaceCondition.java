package practice.threads;

/**
 * In this example, two threads are incrementing a shared counter variable.
 * The final value of counter depends on the order of execution of the threads and can be different
 * each time the program runs. This is a classic race condition.
 *
 * To prevent race conditions, you can use synchronization mechanisms like the synchronized keyword
 * or other constructs provided by the java.util.concurrent package, such as locks and semaphores.
 * Proper synchronization ensures that only one thread can access shared resources or code at a time,
 * preventing data corruption and ensuring consistency.
 */
public class RaceCondition {

    private static int counter = 0;

    public static void main(String[] args) {
        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter++; // Increment the shared counter
            }
        };

        Thread thread1 = new Thread(incrementTask);
        Thread thread2 = new Thread(incrementTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter: " + counter);
    }

}

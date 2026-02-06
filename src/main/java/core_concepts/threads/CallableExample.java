package core_concepts.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Example of using Callable to return a value from a thread.
 *
 * Simulates fetching stock prices from 3 companies and calculating the total portfolio value.
 */
public class CallableExample {
    public static void main(String[] args) throws Exception {

        // 1. Create a pool of 3 workers
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Create a list to hold our "tickets" (Futures)
        List<Future<Double>> receipts = new ArrayList<>();

        // 3. Submit 3 tasks that return a value
        for (int i = 0; i < 3; i++) {
            final String company = (i == 0) ? "Apple" : (i == 1) ? "Google" : "Amazon";

            // We use a lambda that looks like a function (returns a value)
            Callable<Double> task = () -> {
                System.out.println("Fetching price for " + company + "...");
                Thread.sleep(2000); // Simulate network delay
                return 100.0 + new Random().nextDouble() * 50; // Return random price
            };

            // SUBMIT returns a Future immediately!
            Future<Double> future = executor.submit(task);
            receipts.add(future);
        }

        System.out.println("--- All tasks submitted. Main thread doing other work... ---");

        // 4. Collect the results
        double totalValue = 0;
        for (Future<Double> receipt : receipts) {
            // .get() BLOCKS the main thread until the specific task is done
            totalValue += receipt.get();
        }

        System.out.println("✅ Total Portfolio Value: $" + String.format("%.2f", totalValue));
        executor.shutdown();
    }
}

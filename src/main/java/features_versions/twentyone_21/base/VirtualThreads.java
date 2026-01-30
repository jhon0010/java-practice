package features_versions.twentyone_21.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import java.util.concurrent.Future;

public class VirtualThreads {

    public static void main(String[] args) {


        virtualThreadsExample();
        //virtualThreadsExample2();
    }

    public static void virtualThreadsExample2() {
        long start = System.currentTimeMillis();

        List<Future<Integer>> results = new ArrayList<>();

        // 1. Using the new Virtual Thread Executor
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            results = IntStream.range(0, 100_0000).mapToObj(i -> {
                return executor.submit(() -> {
                    // Simulate I/O (Database/API call)
                    Thread.sleep(Duration.ofSeconds(1));
                    //System.out.println("Task " + i + " completed");
                    return i;
                });
            }).toList();
        } // Executor auto-closes after all tasks finish

        results.forEach( future -> {
            try {
                // .get() retrieves the value (or throws an exception if the task failed)
                int result = future.get();
                System.out.println("Processing: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("Finished 1000k tasks in: " + (end - start) + "ms");
    }

    public static void virtualThreadsExample() {
        System.out.println("🚀 Starting 10,000 virtual tasks...");
        long startTime = System.currentTimeMillis();

        // 1. Using try-with-resources ensures the executor shuts down automatically
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            // 2. Submit 10,000 tasks and collect their Futures into a List
            List<Future<Double>> futures = IntStream.range(0, 10_00000)
                    .mapToObj(i -> executor.submit(() -> {
                        // Simulate a network delay (I/O blocking)
                        Thread.sleep(Duration.ofMillis(10000));
                        return Math.random() * 100; // Return a random "price"
                    }))
                    .toList();

            // 3. Process the results using the Streams API
            double average = futures.stream()
                    .mapToDouble(f -> {
                        try {
                            return f.get(); // Extract the value from the Future
                        } catch (InterruptedException | ExecutionException e) {
                            return 0.0;
                        }
                    })
                    .average()
                    .orElse(0.0);

            long endTime = System.currentTimeMillis();

            System.out.printf("✅ Processed %d results.%n", futures.size());
            System.out.printf("📊 Average Price: %.2f%n", average);
            System.out.printf("⏱️ Total Time: %d ms%n", (endTime - startTime));
        }
    }


}

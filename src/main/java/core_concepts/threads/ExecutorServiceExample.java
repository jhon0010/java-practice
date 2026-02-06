package core_concepts.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Example of using ExecutorService to manage a pool of threads.
 *
 * Simulates a bank server that handles PDF generation requests for 10 users and only 3 threads can process at the same time.
 */
public class ExecutorServiceExample {

        public static void main(String[] args) {
            System.out.println("🏦 Bank Server Started...");

            // 1. Create a Pool of 3 workers (The "PDF Generator" Service)
            // If 10 requests come in, 3 get processed immediately, 7 wait in the queue.

            try (ExecutorService reportServer = Executors.newFixedThreadPool(3)) {
                // 2. Simulate 10 users clicking "Download Report" at the same time
                for (int i = 1; i <= 10; i++) {
                    int userId = i;

                    // 3. Submit the task (Order) to the service
                    reportServer.submit(() -> {
                        generatePDF(userId);
                    });
                }
            }

            System.out.println("✅ All requests submitted. Main thread is free to do other work!");
        }

        // This method simulates the heavy work
        private static void generatePDF(int userId) {
            String threadName = Thread.currentThread().getName();
            System.out.println(STR."Processing User \{userId} on \{threadName}");

            try {
                // Simulate 2 seconds to generate a PDF
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted while generating PDF for User " + userId);
            }

            System.out.println("📄 PDF Created for User " + userId);
        }

}

package features_versions.nineteen_19.base;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * JEP 425: Virtual Threads (Preview)
 *
 * This JEP introduces virtual threads, a lightweight implementation of threads provided by the JDK instead of the OS.
 * The number of virtual threads can be much larger than the number of OS threads. These virtual threads help increase
 * the throughput of the concurrent applications.
 */
public class VirtualThreads {

    public static void main(String[] args) {
        usingVirtualThreads();
        usingNewFixedThreadPool();
    }

    public static void usingVirtualThreads() {

        long startTime = System.currentTimeMillis();
        System.out.println(STR."Using virtual threads start time: \{startTime}");

        // finish within 1 second
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }

        long endTime = System.currentTimeMillis();
        System.out.println(STR."Using virtual threads end time: \{endTime}");
        System.out.println(STR."Using virtual threads duration: \{endTime - startTime}");

    }

    /**
     * This method uses the newFixedThreadPool to execute the 10_000 tasks.
     * You probably need to manually stop the process because it takes a long time to finish.
     */
    public static void usingNewFixedThreadPool() {

        long startTime = System.currentTimeMillis();
        System.out.println(STR."Using newFixedThreadPool start time: \{startTime}");

        // 10_000/20 = 500seconds, it takes 8 minutes and 33 seconds to finish it
        try (var executor = Executors.newFixedThreadPool(20)) {
            IntStream.range(0, 10_000).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }

        long endTime = System.currentTimeMillis();
        System.out.println(STR."Using newFixedThreadPool end time: \{endTime}");
        System.out.println(STR."Using newFixedThreadPool duration: \{endTime - startTime}");

    }
















}

package features_versions.twentyone_21.base;

import java.net.http.HttpClient;
import java.time.Duration;

/**
 * An example of some improvements to use the new HttpClient API in Java 21.
 *
 * The ‘HttpClient’ being ‘AutoCloseable’ means you can now use it within a try-with-resources block in Java,
 * which automatically handles the closing of resources once they are no longer needed.
 */
public class HttpClientLifecycleEnhanced {

    public static void main(String[] args) throws InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        /*
            close() method which waits for any ongoing requests to finish
            before closing, once the task has finished it easily closes the HttpClient.
         */
        client.close();

        /*
           * The other method is`shutdown()` that starts closing the HttpClient quickly without waiting for all tasks to end.
         */
        client.shutdown();


        // The awaitTerminationDuration waits for the client to shut down within a specific time duration.
        if (client.awaitTermination(Duration.ofMinutes(1))) {
            System.out.println("Client terminated successfully.");
        } else {
            System.out.println("Client termination took longer than expected.");
        }

        /*
            * isTerminated() is the method which checks if the HttpClient has fully shut down
         */
        if (client.isTerminated()) {
            System.out.println("Client has terminated.");
        }

    }

}

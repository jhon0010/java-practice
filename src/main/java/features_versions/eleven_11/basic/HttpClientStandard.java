package features_versions.eleven_11.basic;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

/**
 * Standard HTTP client in Java 11.
 * This class demonstrates how to use the HttpClient to send synchronous and asynchronous HTTP requests.
 */
public class HttpClientStandard {

    public static void main(String[] args) {
        syncExample(args);
        asyncExample(args);
    }

    /**
     * Example of a synchronous HTTP request using the HttpClient
     * @param args
     */
    public static void syncExample(String[] args) {
        // Create a HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .build();

        // Send the request and receive a HttpResponse
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the status code and body of the response
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Example of an asynchronous HTTP request using the HttpClient
     * @param args
     */
    public static void asyncExample(String[] args) {
        // Create a HttpClient
        HttpClient client = HttpClient.newHttpClient();

        // Create a HttpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .build();

        // Send the request asynchronously and handle the response
        CompletableFuture<HttpResponse<String>> responseFuture =
                client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        responseFuture.thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join(); // Wait for the asynchronous operation to complete
    }

}

package features_versions.nine_9.http_client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.net.Authenticator;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.PasswordAuthentication;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 *
 * The incubated HTTP API from Java 9 is now officially incorporated into the Java SE API. The new HTTP APIs can be found in java.net.HTTP.*
 * The newer version of the HTTP protocol is designed to improve the overall performance of sending requests by a client
 * and receiving responses from the server. This is achieved by introducing a number of changes such as stream multiplexing,
 * header compression and push promises.
 * The API is now fully asynchronous (the previous HTTP/1.1 implementation was blocking). Asynchronous calls are implemented
 *  using CompletableFuture.The CompletableFuture implementation takes care of applying each stage once the previous
 *  one has finished, so this whole flow is asynchronous.
 * The new HTTP client API provides a standard way to perform HTTP network operations with support for modern Web
 * features such as HTTP/2, without the need to add third-party dependencies.
 * The new APIs provide native support for HTTP 1.1/2 WebSocket. The core classes and interface providing the core
 * functionality include:
 */
public class HttpClientExamples {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {

        searchWikipedia("Java Programming");
        httpRequestCustomized();
        httpClientCustomization();
        requestWithDifferentKindOfBody();
        requestWithAuthentication();
    }

    /**
     * This is an example of using the new HttpClient API to search Wikipedia for a given topic.
     * @param topic The topic to search for on Wikipedia.
     */
    public static void searchWikipedia(String topic) {
        String encodedTopic = URLEncoder.encode(topic, StandardCharsets.UTF_8);
        String url = "https://en.wikipedia.org/w/api.php?action=query&list=search&utf8=1&format=json&srsearch=" + encodedTopic;

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) //The API fully leverages the HTTP/2 protocol and uses it by default, but we can define which version of the protocol
                .build();

        /*
         * The client will fall back to, e.g., HTTP/1.1 if HTTP/2 version isn’t supported.
         */
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url)) // also can be created like HttpRequest.newBuilder(new URI("https://postman-echo.com/get"))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());
            JSONObject query = jsonResponse.getJSONObject("query");
            JSONArray searchResults = query.getJSONArray("search");

            System.out.println("Search results for: " + topic);
            for (int i = 0; i < searchResults.length(); i++) {
                JSONObject article = searchResults.getJSONObject(i);
                System.out.println((i + 1) + ": " + article.getString("title") + ", that have a number of word = " + article.get("wordcount"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method shows how to customize the HttpClient object.
     * - Set the version of the http protocol.
     * - Set the redirect policy. In that case, we’ll receive HTTP status code 3xx, usually with the information
     *          about new URI. HttpClient can redirect the request to the new URI automatically if we set the appropriate
     *          redirect policy.
     * - Set the timeout for the connection.
     * - Set the proxy for the connection.
     * - Set the cookie handler - In this example not accepting any cookie.
     */
    public static void httpClientCustomization() {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.getDefault())
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .connectTimeout(Duration.ofSeconds(20))
                .cookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_NONE))
                .build();

        /*
           We can see what specific cookie manager is used by our http client.
         */
        ((CookieManager) httpClient.cookieHandler().get()).getCookieStore();
    }

    /**
     * In this method you can see how to create a request with:
     *  - custom version of the http protocol.
     *  - custom headers (can also do .headers("key1", "value1", "key2", "value2"))
     *  - set a timeout for the request
     *
     * @throws URISyntaxException If the URI is not well-formed.
     */
    public static void httpRequestCustomized() throws URISyntaxException {
        HttpClient client = HttpClient.newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .version(HttpClient.Version.HTTP_2)
                .header("key1", "value1")
                .header("key2", "value2")
                .timeout(Duration.of(3, ChronoUnit.SECONDS))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The new API provides a number of BodyPublisher implementations out-of-the-box that simplify passing the request body
     *   - StringProcessor – reads body from a String, created with HttpRequest.BodyPublishers.ofString
     *   - InputStreamProcessor – reads body from an InputStream, created with HttpRequest.BodyPublishers.ofInputStream
     *   - ByteArrayProcessor – reads body from a byte array, created with HttpRequest.BodyPublishers.ofByteArray
     *   - FileProcessor – reads body from a file at the given path, created with HttpRequest.BodyPublishers.ofFile
     *   - NoBody - doesn't send a body with the request.
     */
    public static void requestWithDifferentKindOfBody() throws URISyntaxException, FileNotFoundException {

        // NoBody
        HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();

        //StringProcessor
        HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString("Sample request body"))
                .build();

        // Body from File
        HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofFile(
                        Paths.get("src/main/resources/sample.txt")))
                .build();

    }

    /**
     * An Authenticator is an object that negotiates credentials (HTTP authentication) for a connection.
     * It provides different authentication schemes (such as basic or digest authentication).
     *
     * In this example we are using the basic authentication (username, password) scheme.
     */
    public static void requestWithAuthentication() {
        HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "username",
                                "password".toCharArray());
                    }
                }).build();
    }

    /**
     * When we are using the function send in a httpClient this means it is synchronous request.
     * If we want to make an asynchronous request we can use the function sendAsync, the response will be a CompletableFuture.
     *
     * In this example we send different request toa  set of URLs asynchronously, and then we collect the responses in a list of CompletableFuture.
     */
    public static void asynchronousRequest() throws URISyntaxException {

        List<URI> targets = Arrays.asList(
                new URI("https://postman-echo.com/get?foo1=bar1"),
                new URI("https://postman-echo.com/get?foo2=bar2"));
        HttpClient client = HttpClient.newHttpClient();
        List<CompletableFuture<String>> futures = targets.stream()
                .map(target -> client
                        .sendAsync(
                                HttpRequest.newBuilder(target).GET().build(),
                                HttpResponse.BodyHandlers.ofString())
                        .thenApply(response -> response.body()))
                .collect(Collectors.toList());

    }

}

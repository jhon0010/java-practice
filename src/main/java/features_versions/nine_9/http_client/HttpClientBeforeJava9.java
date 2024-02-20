package features_versions.nine_9.http_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This is a simple example of how to consume an endpoint using HttpURLConnection before Java 9.
 */
public class HttpClientBeforeJava9 {

    public static void main(String[] args) {

        try {
            System.out.println(consumeEndpointBeforeJava9());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This is a simple GET request using HttpURLConnection.
     * @return the body content response from the endpoint.
     * @throws IOException if an error occurs.
     */
    public static String consumeEndpointBeforeJava9() throws IOException {

        URL url = new URL("https://dog.ceo/api/breeds/image/random");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        return content.toString();
    }

}

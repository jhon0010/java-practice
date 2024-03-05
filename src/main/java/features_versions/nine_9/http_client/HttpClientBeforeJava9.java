package features_versions.nine_9.http_client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * This is a simple example of how to consume an endpoint using HttpURLConnection before Java 9.
 */
public class HttpClientBeforeJava9 {

    public static void main(String[] args) {
        try {
            int barcode = 123456; // Example barcode
            double finalPrice = getFinalPrice(barcode);
            System.out.println("Final price: " + finalPrice);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double getFinalPrice(int barcode) throws Exception {
        String requestUrl = "https://jsonmock.hackerrank.com/api/inventory?barcode=" + barcode;
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Request failed with HTTP code: " + responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            response.append(inputLine);
        }
        reader.close();

        // Manually parsing the JSON response
        String responseBody = response.toString();
        double price = parseValueFromJson(responseBody, "price");
        double discount = parseValueFromJson(responseBody, "discount");

        // Calculate the final price
        return price - (price * discount / 100);
    }

    // A simple method to extract numerical values from the JSON response
    private static double parseValueFromJson(String json, String key) {
        String[] parts = json.split(key + "\":");
        if (parts.length > 1) {
            String[] valueParts = parts[1].split(",");
            String valueStr = valueParts[0].trim();
            if (valueStr.endsWith("}")) {
                valueStr = valueStr.substring(0, valueStr.length() - 1);
            }
            return Double.parseDouble(valueStr);
        }
        return 0;
    }
}


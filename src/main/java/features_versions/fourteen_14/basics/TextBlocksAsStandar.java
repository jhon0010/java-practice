package features_versions.fourteen_14.basics;

/**
 * Text Blocks is a new feature in Java 14 that allows you to create multi-line strings without using escape sequences.
 */
public class TextBlocksAsStandar {

    public static void main(String[] args) {

        // before text blocks in Java 14
        String json = "{\n" +
                "    \"name\": \"John\",\n" +
                "    \"age\": 30\n" +
                "}";

        String json14 = """
              {
                  "name": "John",
                  "age": 30
              }
              """;

        System.out.println(json);
        System.out.println(json14);

    }
}

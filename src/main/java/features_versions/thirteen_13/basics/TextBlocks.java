package features_versions.thirteen_13.basics;

/**
 * TextBlocks: Text blocks are a new feature in Java 13. They are a multi-line string literal that avoids the need for
 */
public class TextBlocks {

    public static void main(String[] args) {
        var textBlock = """
            This is a text block.
            It is a new feature in Java 13.
            It is a multi-line string.
            """;
        System.out.println(textBlock);
    }

}

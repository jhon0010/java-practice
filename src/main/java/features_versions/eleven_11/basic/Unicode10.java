package features_versions.eleven_11.basic;

/**
 * Java 11 introduced support for Unicode 10, enhancing the Java platform's global language support by adding new
 * characters, scripts, and symbols. Unicode 10, released in June 2017, brought a total of 136,690 characters,
 * encompassing 139 different scripts, along with various symbol sets and emojis. This update is crucial for applications
 * that process text, ensuring they can support the latest language characters and symbols used worldwide.
 */
public class Unicode10 {

    public static void main(String[] args) {
        // Example of using a new emoji character from Unicode 10
        String emoji = "\uD83E\uDDFF"; // Mage emoji

        // Printing the emoji
        System.out.println("Unicode 10 Emoji: " + emoji);

        // Using a new script character
        String bitcoin="₿"; // An example character from the Cuneiform script added in Unicode 10

        // Printing the script character
        System.out.println("Unicode 10 Script Character: " + bitcoin);

        String emojiCopied = "\uD83E\uDD2F";
        System.out.println("Unicode 10 Emoji: " + emojiCopied);

    }

}

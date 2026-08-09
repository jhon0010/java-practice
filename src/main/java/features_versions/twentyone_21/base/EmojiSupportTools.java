package features_versions.twentyone_21.base;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Java has introduced the method in the ‘java.lang.Character’ class to work with different types of emoji’s properties,
 * it’s defined by the Unicode Standard (unicode emoji technical standard) UTS#51.
 * Let’s take an example, checking whether the given code points to a unique number representing a character as an emoji.
 */
public class EmojiSupportTools {
    public static void main(String[] args) {
        System.out.println("👋🏽 Hello, Java 21!");

        boolean canHaveModifier = Character.isEmojiModifierBase('✋');
        System.out.println("Can have modifier: " + canHaveModifier);

        Set<Integer> emojis = new HashSet<>();
        emojis.add("😂".codePointAt(0));
        emojis.add("😄".codePointAt(0));
        String s = "1😂34😄5";
        s.codePoints().forEach( codepoint -> {
            System.out.println(
                    new String(Character.toChars(codepoint))
                            + " "
                            + emojis.contains(codepoint));
        });
    }
}

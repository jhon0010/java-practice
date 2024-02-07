package features_versions.thirteen_13.basics;

/**
 * YieldSwitchCase: We initially saw switch expressions in JDK 12. Java 13’s switch expressions build on the previous
 * version by adding a new yield statement.
 * Using yield, we can now effectively return values from a switch expression:
 */
public class YieldSwitchCase {

    public static void main(String[] args) {

        var me = 4;
        var operation = "squareMe";
        var result = switch (operation) {
            case "doubleMe" -> {
                yield me * 2;
            }
            case "squareMe" -> {
                yield me * me;
            }
            default -> me;
        };
        System.out.println(result);
    }

}

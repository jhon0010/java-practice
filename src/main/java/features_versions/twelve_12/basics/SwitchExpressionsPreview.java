package features_versions.twelve_12.basics;

/**
 * Java 12 introduced a new syntax for switch expressions as a preview feature, aimed at simplifying the traditional
 * switch statement and allowing it to be used as either a statement or an expression.
 * This feature enhances code readability and reduces boilerplate.
 */
public class SwitchExpressionsPreview {

    // create an enum for the days of the week
    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        // Traditional switch statement

        Day day = Day.MONDAY;
        String result = "";
        switch (day) {
            case MONDAY:
            case FRIDAY:
            case SUNDAY:
                result = "6";
                break;
            case TUESDAY:
                result = "7";
                break;
            // More cases...
        }

        // Java 12 switch expression
        String result12 = switch (day) {
            case WEDNESDAY -> null;
            case THURSDAY -> null;
            case SATURDAY -> null;
            case MONDAY, FRIDAY, SUNDAY -> "6";
            case TUESDAY                -> "7";
            // More cases...
        };

    }

}

package features_versions.eighteen_18.base;

/**
 * The switch expression requires all possible values to
 * be handled in the switch block, else prompts a compile-time error.
 */
public class ExhaustivenessSwitchExpressions {

    public static void main(String[] args) {
        coverage("Hello");
    }

    static int coverage(Object o) {
        /**
         // Error - not exhaustive switch expression, force you to implement default case or all possible values.
         return switch (o) {
         case String s  -> s.length();
         case Integer i -> i;
         };*/

        return switch (o) {
            case String s -> s.length();
            case Integer i -> i;
            default -> -1;
        };
    }


}

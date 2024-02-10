package features_versions.eighteen_18.base;

/**
 * Review the below switch pattern matching, every value that matches the String s also matches the CharSequence cs,
 * which makes String s unreadable and will cause a compile-time error.
 */
public class DominanceCheckingSameType {

    static void error (Object o){
        switch (o) {
            case CharSequence cs -> System.out.println("A sequence of length " + cs.length());
            /*
             //Compile time Error - pattern is dominated by previous pattern doesn't happen before could lead to a bug
            case String s ->
                    System.out.println("A string: " + s);
             */
            default -> {
                break;
            }
        }
    }

}

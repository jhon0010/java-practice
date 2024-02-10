package features_versions.nineteen_19.base;

/**
 * Nested Record pattern is a new feature in Java 19
 */
public class RecordNestedPatternsExample {

    public static void main(String[] args) {

        printSum(new Total(new Point(10, 5), new Point(2, 3)));
    }

    /**
     * Record pattern
     * @param x
     * @param y
     */
    record Point(int x, int y) {    }


    /**
     * Nested record pattern
      * @param p1
     * @param p2
     */
    record Total(Point p1, Point p2) {}


    static void printSum(Object o) {
        // record nested pattern
        if (o instanceof Total(Point(int x,int y),Point(int x2,int y2))) {
            System.out.println(x + y + x2 + y2);
        }
    }

}

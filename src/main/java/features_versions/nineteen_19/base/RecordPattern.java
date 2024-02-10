package features_versions.nineteen_19.base;

public class RecordPattern {

    public static void main(String[] args) {
        printSumBefore19(new Point(1, 2));
        printSumNew19(new Point(1, 2));
    }

    record Point(int x, int y) { }

    static void printSumBefore19(Object o) {
        if (o instanceof Point p) {
            int x = p.x();  // get x()
            int y = p.y();  // get y()
            System.out.println(x + y);
        }
    }

    static void printSumNew19(Object o) {
        if (o instanceof Point(int x,int y)) {  // record pattern
            System.out.println(x + y); // access x and y directly
        }
    }

}

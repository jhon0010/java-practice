package features_versions.fourteen_14.basics;

/**
 * Record is a new type in Java 14 that is used to create a simple data class.
 */
public class RecordExample {
    PointRecord pointRecord = new PointRecord(10, 20);
    Point point = new Point(10, 20);
}

/**
 * Java 14 introduces a new type called record. A record is a data class that is immutable and transparent.
 * @param x
 * @param y
 */
record PointRecord(int x, int y) { }


/**
 * Before Java 14 you would have to write a lot of boilerplate code to create a simple data class.
 */
class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


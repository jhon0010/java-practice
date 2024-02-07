package features_versions.ten_10.basics;

import java.util.HashMap;
import java.util.List;

/**
 * Java 10 introduced the var keyword, which allows you to declare local variables without specifying their types.
 */
public class LocalVariables {

    public static void main(String[] args) {
        var message = "Hello, Java 10!";
        var numbers = List.of(1, 2, 3, 4, 5);
        var map = new HashMap<String, Integer>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(message);
        System.out.println("Numbers: " + numbers);
        System.out.println("Map: " + map);
    }

}

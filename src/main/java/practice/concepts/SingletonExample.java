package practice.concepts;

import java.util.ArrayList;
import java.util.List;

public class SingletonExample {

    public static final int INMUTABLE_VARIABLE = 5;
    public static int numberOfInstances = 0;
    public static List<String> kindsOfJavaStatics = new ArrayList<>();


    private static class SingletonHolder {
        public static final SingletonExample instance = new SingletonExample();
    }

    public static SingletonExample getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        System.out.println(kindsOfJavaStatics.toString());
        numberOfInstances++;
    }

    static {
        kindsOfJavaStatics.add("static variable");
        kindsOfJavaStatics.add("static method");
        kindsOfJavaStatics.add("static blocks like this ;)");
        kindsOfJavaStatics.add("static class");

    }

}

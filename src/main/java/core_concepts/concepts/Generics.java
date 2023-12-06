package core_concepts.concepts;

import java.util.List;

/**
 * You can create a generic class by specifying one or more type parameters within angle brackets ("< >"). These type
 * parameters act as placeholders for actual data types that will be provided when you create an instance of the
 * generic class.
 * @param <T>
 */
class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

/**
 * Generics in Java provide a way to create classes, interfaces, and methods that can operate on different data types
 * without sacrificing type safety. Generics allow you to write more reusable and type-safe code.
 *
 * Type Inference:The Java compiler can often infer the type parameters based on the context, reducing the need
 * for explicit type specification.
 *
 *  Unbounded Wildcard <?>
 */
public class Generics {

    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>();
        intBox.setValue(42);
        int value = intBox.getValue(); // No casting needed
        System.out.println("Int value got from Box<T> = " + value);

        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics!");
        String message = stringBox.getValue(); // No casting needed
        System.out.println("String value got from Box<T> = " + message);

        Integer[] intArray = { 3, 7, 2, 8, 1 };
        Integer maxInt = findMax(intArray);
        System.out.println(maxInt);

        String[] stringArray = { "apple", "banana", "cherry" };
        String maxString = findMax(stringArray);
        System.out.println(maxString);

        // the type parameter T must be a subclass of Number
        printList(List.of(1, 2, 3));

        // the type parameter T must be a subclass of Integer (or Integer itself)
        addNumbers(List.of(1, 2, 3));

    }

    /**
     * You can restrict the types that can be used as type parameters by using bounded type parameters. For example,
     * you can specify that a type parameter must be a subclass of a particular class or implement a specific interface.
     *
     * @param array
     * @return
     * @param <T>
     */
    public <T extends Number> double sumOfArray(T[] array) {
        double sum = 0.0;
        for (T element : array) {
            sum += element.doubleValue();
        }
        return sum;
    }

    /**
     * You can also use multiple bounds for a type parameter. For example, the following method accepts a type parameter
     * that must extends from Comparable, this allows you to write more generic code.
     *
     * @param array the array to find the maximum value.
     * @return the maximum value in the array.
     * @param <T extends Comparable<T>> the type parameter T must be a subclass of Comparable<T>
     */
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];
        for (T element : array) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }

        return max;
    }

    /**
     * Unbounded Wildcard <?>:
     *
     * It represents an unknown type.
     * It can be used for read-only access when the exact type doesn't matter.
     * Example: Printing the elements of a list without knowing the element type.
     *
     * @param list the list to print.
     */
    static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    /**
     * Lower Bounded Wildcard <? super T>
     *
     * It represents a type that is a supertype of type T.
     * It's used when you want to work with any supertype of a specific type.
     * Example: Adding elements to a list when the element type is known to be a supertype.
     * @param numbers the list to add elements to.
     */
    static void addNumbers(List<? super Integer> numbers) {
        numbers.add(1);
        numbers.add(2);
    }

}

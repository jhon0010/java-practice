package practice.eight_8.interfaces.defualt.method;

/**
 * defaults are accessible through the instance of the implementing class and can be overridden.
 *
 * The most typical use of default methods in interfaces is to incrementally provide additional functionality to a given
 * type without breaking down the implementing classes for example in legacy systems.
 *
 * Suppose do you have a {@link CalculatorInterface} interface and you want to
 * give to all the classes that implements it have the same behaviour and you don't
 * have to implemented it just add a default behaviour.
 *
 * If any other class wants to change this behaviour just have to override the method.
 *
 *  In a typical design based on abstractions, where an interface has one or multiple implementations, if one or more
 *  methods are added to the interface, all the implementations will be forced to implement them too. Otherwise,
 *  the design will just break down.
 */
public interface CalculatorInterface {

    /**
     * The default method add expected inheritance behaviour to a class that implement this interface.
     */
    default double sum(double num1, double num2){
        return num1 + num2;
    }

    /**
     * You can have multiple default methods.
     */
    default double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * You can have another abstract method definitions.
     */
    double subtract(double num1, double num2);

}

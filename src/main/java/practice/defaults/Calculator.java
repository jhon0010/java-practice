package practice.defaults;

/**
 * Suppose do you have a {@link Calculator} interface and you want to
 * give to all the classes that implements it have the same behaviour (They can overrate it).
 */
public interface Calculator {

    /**
     * The default method add expected inheritance behaviour to a class that implement this interface.
     * @param num1
     * @param num2
     * @return
     */
    default double sum(double num1, double num2){
        return num1 + num2;
    }

    double substract(double num1, double num2);

}

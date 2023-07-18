package practice.eight_8.lambda.functional.interfaces;

/**
 * The annotation only force to have one method in this interface.
 *
 *  Note that instances of functional interfaces can be created with
 *  lambda expressions, method references, or constructor references.
 */
@FunctionalInterface
public interface OperationFunctionalInterface {

    double sum(double num1, double num2);
}

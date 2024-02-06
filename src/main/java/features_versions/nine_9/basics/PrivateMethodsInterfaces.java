package features_versions.nine_9.basics;

/**
 * In Java 9, one of the language enhancements is the introduction of private methods in interfaces. Before Java 9,
 * interfaces in Java could only have public abstract methods (except for static and default methods introduced in Java 8).
 * The addition of private methods in Java 9 allows developers to create methods in interfaces that cannot be accessed
 * by implementing classes or used as part of the interface's public API.
 */
public interface PrivateMethodsInterfaces {

    // A default method that calls a private method
    default void defaultMethod() {
        System.out.println("Default Method");
        privateMethod();
    }

    // Another default method that calls the same private method
    default void anotherDefaultMethod() {
        System.out.println("Another Default Method");
        privateMethod();
    }

    // Private method inside the interface
    private void privateMethod() {
        System.out.println("Private Method");
    }

}

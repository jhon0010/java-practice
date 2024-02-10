package features_versions.twenty_20.base;

import domain.User;

/**
 * ScopedValueExample
 * Scoped values provide a simple, immutable, and inheritable data-sharing option, specifically in situations where we’re
 * working with a large number of threads.
 * A ScopedValue is an immutable value that is available for reading for a bounded period of execution by a thread.
 * Since it’s immutable, it allows safe and easy data-sharing for a limited period of thread execution. Also, we need not
 * pass the values as method arguments.
 * We can use the where() method of the class ScopedValue to set the value of a variable for the bounded period of thread execution.
 * Moreover, once we get the data using the get() method, we cannot access it again.Once the run() method of a thread finishes
 * execution, the scoped value reverts to the unbound state. We can use the get() method to read the value of a scoped-value variable
 * inside a thread.
 */
public class ScopedValueExample {

    // Declare a scoped value for storing a user object
    public static final ScopedValue<User> LOGGED_IN_USER = ScopedValue.newInstance();

    public static void main(String[] args) {
        // Set the scoped value to the currently logged-in user
        ScopedValue.where(LOGGED_IN_USER, getCurrentUser()).run(() -> {
            // Process the user request
            processUserRequest();
        });
        System.out.println();
    }

    public static void processUserRequest() {
        // Retrieve the logged-in user from the scoped value
        User user = LOGGED_IN_USER.get();
        // Process the user request
        System.out.println(STR."Processing user request for \{user.getName() + " (" + user.getLastName()  + ")"}");
    }

    public static User getCurrentUser() {
        // Retrieve the currently logged-in user
        return User.getAnExampleUser();
    }

}

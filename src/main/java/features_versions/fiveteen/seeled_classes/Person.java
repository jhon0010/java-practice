package features_versions.fiveteen.seeled_classes;

/**
 * Sealed classes restrict which other classes may extend or implement them, allow more control over the inheritance hierarchy.
 * In this example, the Person class is sealed, and permits only the Employee and Manager classes to extend it.
 *
 * It’s important to note that any class that extends a sealed class must itself be declared sealed, non-sealed, or final.
 * This ensures the class hierarchy remains finite and known by the compiler.
 */
public abstract sealed class Person permits Employee, Manager {
    public String getId() {
        return "PersonId: 1234";
    }
}

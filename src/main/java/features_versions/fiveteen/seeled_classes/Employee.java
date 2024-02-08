package features_versions.fiveteen.seeled_classes;

/**
 * The Employee class extends the Person class, which is sealed.
 * The Employee class should be market as non-sealed, final, or permit other classes to extend it.
 *
 * For this example, the Employee class is marked as final, that does not allow any class to extend it.
 */
public final class Employee extends Person {
    public String getEmployeeId() {
        return "EmployeeId: 1234";
    }
}

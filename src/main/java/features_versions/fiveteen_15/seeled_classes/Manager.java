package features_versions.fiveteen_15.seeled_classes;

/**
 * The Manager class extends the Person class, which is sealed.
 *
 * The Manager class should be market as non-sealed, final, or permit other classes to extend it.
 * For this example, the Manager class is marked as non-sealed, that allows any class to extend it.
 */
public non-sealed class Manager extends Person {
    public String getManagerId() {
        return "ManagerId: 1234";
    }
}

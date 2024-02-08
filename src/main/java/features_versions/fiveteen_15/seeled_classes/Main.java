package features_versions.fiveteen_15.seeled_classes;

/**
 * This is just a simple example to show how sealed classes work with Polymorphism ina  more restricted way.
 */
public class Main {

        public static void main(String[] args) {

            Person person = new Employee();
            printId(person);
        }

        public static void printId(Person person) {
            System.out.println(person);

            String id = "";

            if (person instanceof Employee) {
                id = ((Employee) person).getEmployeeId();
            } else if (person instanceof Manager) {
                id = ((Manager) person).getManagerId();
            }

            System.out.println(id);
        }


}

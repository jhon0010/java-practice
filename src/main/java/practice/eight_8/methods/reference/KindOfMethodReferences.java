package practice.eight_8.methods.reference;

import domain.User;
import org.slf4j.Logger;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.slf4j.LoggerFactory.getLogger;


public class KindOfMethodReferences {

    private static final Logger LOGGER = getLogger(KindOfMethodReferences.class);

    public static void main(String[] args) {

        List<User> users = User.defaultList();
        List<String> names = asList("John", "Doe", "Bean", "");
        objectMethodReference(names);
        staticMethodReference(users);
        instanceReferenceMethod(users);
        constructorMethodReference(names);
    }

    /**
     * A reference to a constructor takes the following syntax: ClassName::new. As constructor in Java is a special
     * method, method reference could be applied to it too with the help of new as a method name.
     */
    private static void constructorMethodReference(List<String> names) {
        Stream<User> stream = names.stream().map(User::new);
    }

    /**
     * This reference method takes the following syntax: ContainingType::methodName
     */
    private static void objectMethodReference(List<String> names) {
        final long numEmptyResult = names.stream().filter(String::isEmpty).count();
        LOGGER.info("The list " + names.toString() + " have " + numEmptyResult + " empty results");
    }

    /**
     * The reference to an instance method holds the following syntax: containingInstance::methodName
     */
    private static void instanceReferenceMethod(List<User> users) {
        User u = new User();
        final boolean haveAdult = users.stream().anyMatch(u::isAdult);
        LOGGER.info("The instance reference method have adults " + haveAdult);
    }

    /**
     * The reference to a static method holds the following syntax: ContainingClass::methodName
     */
    private static void staticMethodReference(List<User> users) {

        final boolean isValidUser = users.stream().anyMatch(u -> User.isValidUser(u));
        //Reference to static method
        final boolean isValidUserMethodReference = users.stream().anyMatch(User::isValidUser);

        LOGGER.info("The list " + users.toString() + " \n" + " have valid users = " +
                isValidUser + isValidUserMethodReference);
    }
}

package features_versions.eight_8.functional;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class CallbacksPassingFunctionAsParameter {

    private static final Logger LOGGER = Logger.getLogger(CallbacksPassingFunctionAsParameter.class.getName());


    public static void main(String[] args) {

        greet("Jhon", null, name -> LOGGER.warning("No lastname provided for greet " + name));
    }

    public static void greet (String name, String lastName, Consumer<String> callback) {
        LOGGER.info("Greeting " + name);
        if (lastName != null) {
            LOGGER.info("Last name = " + lastName);
        } else {
            callback.accept(name);
        }
    }

}

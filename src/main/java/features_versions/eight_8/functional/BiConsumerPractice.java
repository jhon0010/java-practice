package features_versions.eight_8.functional;

import domain.User;

import java.util.function.BiConsumer;
import java.util.logging.Logger;


public class BiConsumerPractice {

    private static final Logger LOGGER = Logger.getLogger(BiConsumerPractice.class.getName());

    public static void main(String[] args) {
        User jhon = User.getAnExampleUser();

        greetUserConsumerShowEmail.accept(jhon, false);
    }

    static BiConsumer<User, Boolean> greetUserConsumerShowEmail = (user, showEmail) ->
            LOGGER.info("Hello new user " + user.getName() + " welcome to our platform \n" +
                    "we send you an email with the instruction for shop in our platform " +
                    "to the direction " + (showEmail ? user.getEmail() : "*******"));
}

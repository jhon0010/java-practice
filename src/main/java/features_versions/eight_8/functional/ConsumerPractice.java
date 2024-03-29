package features_versions.eight_8.functional;

import domain.User;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Consumer = Is a method that takes one argument and return nothing (void).
 * Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
 */
public class ConsumerPractice {

    private static final Logger LOGGER = Logger.getLogger(ConsumerPractice.class.getName());

    public static void main(String[] args) {
        User jhon = User.getAnExampleUser();
        jhon.setEmail(Optional.of("jhon.doe@gmail.com"));
        greetUserImperative(jhon);
        greetUserConsumer.accept(jhon);
    }

    static Consumer<User> greetUserConsumer = user ->
            LOGGER.info("Hello new user " + user.getName() + " welcome to our platform," +
            "we send you an email with the instruction for shop in our platform " +
            "to the direction " + user.getEmail());

    static void greetUserImperative(User user){
        LOGGER.info("Hello new user " + user.getName() + " welcome to our platform," +
                "we send you an email with the instruction for shop in our platform " +
                "to the direction " + user.getEmail());
    }

}

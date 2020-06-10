package practice.eight_8.functional;

import domain.User;
import org.slf4j.Logger;

import java.util.function.Consumer;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Consumer = Is a method that takes one argument and return nothing (void).
 */
public class ConsumerPractice {

    private static final Logger LOGGER = getLogger(ConsumerPractice.class);

    public static void main(String[] args) {
        User jhon = new User("Jhon");
        jhon.setEmail("jhon.doe@gmail.com");
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

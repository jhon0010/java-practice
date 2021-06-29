import domain.Gender;
import domain.User;
import org.slf4j.Logger;
import practice.eight_8.combinator_patterns.UserValidatorService;

import java.time.LocalDate;

import static org.slf4j.LoggerFactory.getLogger;

public class Main {

    private static final Logger LOGGER = getLogger(Main.class);

    public static void main(String[] args) {
        usingCombinationPatternValidator();
    }


    private static void usingCombinationPatternValidator () {
        UserValidatorService userValidator = UserValidatorService.isEmailValid()
                .and(UserValidatorService.isAnAdult())
                .and(UserValidatorService.isPhoneValid());

        User.defaultList()
                .forEach(user -> LOGGER.info(userValidator.apply(user).toString()));


        User u = new User(18, "Jhon", "Lotero", "jhon@gmail.com", Gender.MALE,
                "+0354587", LocalDate.of(1990, 11, 16));

        UserValidatorService.ValidationResult validationResult = UserValidatorService.isEmailValid()
                .and(UserValidatorService.isAnAdult())
                .and(UserValidatorService.isPhoneValid())
                .apply(u);

        LOGGER.info(validationResult.toString());
    }


}

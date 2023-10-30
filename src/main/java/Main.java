import domain.User;
import org.slf4j.Logger;
import practice.eight_8.combinator_patterns.UserValidatorService;

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

        User u = User.getAnExampleUser();

        UserValidatorService.ValidationResult validationResult = UserValidatorService.isEmailValid()
                .and(UserValidatorService.isAnAdult())
                .and(UserValidatorService.isPhoneValid())
                .apply(u);

        LOGGER.info(validationResult.toString());
    }
}
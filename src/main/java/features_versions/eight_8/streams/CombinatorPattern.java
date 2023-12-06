package features_versions.eight_8.streams;

import domain.User;
import features_versions.eight_8.combinator_patterns.UserValidatorService;

import java.util.logging.Logger;

public class CombinatorPattern {

    private static final Logger LOGGER = Logger.getLogger(CombinatorPattern.class.getName());

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

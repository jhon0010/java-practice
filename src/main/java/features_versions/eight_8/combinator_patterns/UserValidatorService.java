package features_versions.eight_8.combinator_patterns;

import domain.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static features_versions.eight_8.combinator_patterns.UserValidatorService.*;
import static features_versions.eight_8.combinator_patterns.UserValidatorService.ValidationResult.*;

/**
 * Using the combinator pattern, allowing us to chain all the functions together
 * with and function specified below.
 *
 * Combinator pattern is lazy and only run when the apply method is call.
 *
 * This increase the composition over inheritance principle, the using code looks like:
 *
 *         User u = new User(18, "Jhon", "Lotero", "jhon@gmail.com", Gender.MALE,
 *                 "+0354587", LocalDate.of(1990, 11, 16));
 *
 *         UserValidatorService.ValidationResult validationResult = UserValidatorService.isEmailValid()
 *                 .and(UserValidatorService.isAnAdult())
 *                 .and(UserValidatorService.isPhoneValid())
 *                 .apply(u);
 *
 *         LOGGER.info(validationResult.toString());
 *
 *
 * This receives a user as an argument
 * and returns a ValidationResult that is an enum with the validations
 */
public interface UserValidatorService extends Function<User, ValidationResult> {

    static UserValidatorService isEmailValid(){
        return user -> user.getEmail()
                .map(email -> email.contains("@") ? SUCCESS : EMAIL_INVALID)
                .orElse(EMPTY_EMAIL);
    }

    static UserValidatorService isPhoneValid(){
        return user -> user.getPhoneNumber().contains("+") ? SUCCESS : PHONE_INVALID;
    }

    static UserValidatorService isAnAdult(){
        return user -> Period.between((user.getDateOfBirth()), LocalDate.now()).getYears() > 18 ?
                SUCCESS : NOT_AN_ADULT;
    }

    /**
     * This is the method where the magic happen allowing us to
     * call an UserValidatorService function then with the 'and' function here
     * we can chain the others functions to have custom validations with specific
     * functions.
     * @param other One of the functions defined in this functional interface.
     * @return UserValidatorService -> ValidationResult
     */
    default UserValidatorService and (UserValidatorService other) {
        return user -> {
            ValidationResult result = this.apply(user);
            return result.equals(SUCCESS) ? other.apply(user) : result;
        };
    }

    /**
     * Enum with the possibles values for these validations.
     */
    enum ValidationResult {
        SUCCESS,
        EMAIL_INVALID,
        EMPTY_EMAIL,
        PHONE_INVALID,
        NOT_AN_ADULT
    }

}

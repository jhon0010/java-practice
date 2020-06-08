package practice.eight_8.optional;

import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;
import static org.slf4j.LoggerFactory.getLogger;

public class OptionalUses {

    private static final Logger LOGGER = getLogger(OptionalUses.class);

    public static void main(String[] args) {

        List<String> listOpt = getTodayWinnerNames().orElseGet(ArrayList::new);
        LOGGER.info("The optional list returns " + listOpt.toString());
    }

    
    private static Optional<List<String>> getTodayWinnerNames(){

        List<String> names = asList("John", "Doe", "Bean", "Peter");
        return System.currentTimeMillis() % 2 == 0
                ? Optional.of(names) : Optional.empty();
    }

}

package features_versions.eight_8.streams;

import org.slf4j.Logger;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.Random;

import static org.slf4j.LoggerFactory.getLogger;

public class OtherStreamExamples {

    private static final Logger LOGGER = getLogger(OtherStreamExamples.class);


    public static void main(String[] args) {
        //countingWords();
        //streamIntMin();
        //streamIntMax();
        sumWithReduce();
    }


    public static void countingWords(){

        List<String> phrases = Arrays.asList(
                "One flew over the cuckoo's nest",
                "To kill a muckingbird",
                "Gone with the wind"
        );

        long numberOfWords = phrases.stream().flatMap(phrase ->
                Arrays.stream(phrase.split(" "))
        ).count();

        LOGGER.info(MessageFormat.format("In the array phrases are {0} number of words", numberOfWords));
    }

    public static void streamIntMin(){

        OptionalInt minRandomNumber = new Random().ints().limit(20).min();
        LOGGER.info(MessageFormat.format("In the random integer array the min is {0} ",
                minRandomNumber.orElse(0)));
    }

    public static void streamIntMax(){

        OptionalInt minRandomNumber = new Random().ints().limit(20).max();
        LOGGER.info(MessageFormat.format("In the random integer array the max value is {0} ",
                minRandomNumber.orElse(0)));
    }

    public static void sumWithReduce(){

        Integer sumOfValues = Arrays.asList(10, 20, 30, 40).stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        Integer sum = Arrays.asList(10, 20, 30, 40).stream()
                .reduce(Integer::sum).orElse(0);

        LOGGER.info("The sum of the number array is " + sumOfValues);

    }

    public static void streamToArray(){
        Object[] objects = Arrays.asList(
                "One flew over the cuckoo's nest",
                "To kill a muckingbird",
                "Gone with the wind"
        ).stream().toArray();

    }

}

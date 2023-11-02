package practice.eight_8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Exercises {


    public static void main(String[] args) {

        String text = "This is a sample sentence. Count the words in this text.";


        //sumEvenNumbers();
        numWordsOnString(text);
    }


    /**
     * You have a list of integers. Write a Java 8 stream that
     * finds the sum of all even numbers in the list.
     */
    public static int sumEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenSum = numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Even sum is = " + evenSum);
        return evenSum;
    }


    public static long numWordsOnString(String phrase) {

        long numWords = Stream.of(phrase.split(" "))
                .count();

        System.out.println("Num words " + numWords);
        return numWords;
    }

}

import domain.Customer;
import domain.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This is a general review to remember some terminology
 */
public class GeneralReview {

    public static void main(String[] args) {

        //Function<Integer, Integer> squared = num -> num * num;

        System.out.println(getSquared().apply(5));
        //collect();

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        List<String> words = Arrays.asList("a","b","c", "aa", "bbb", "ccc");


        //Filtering elements: Given a list of integers, filter out all the even numbers and print the result.
        numbers.stream().filter(x -> x % 2 == 0).forEach(x -> System.out.println("" + x));

        //Mapping elements: Given a list of strings, convert all the strings to uppercase using the map function, and then print the result.
        words.stream().map(String::toUpperCase).forEach(x -> System.out.println("" + x));


        //Sorting elements: Given a list of strings, sort them in ascending order of their length using the sorted function.
        // words.stream().sorted((str1, str2) -> str1.length() - str2.length()); // same as the below one
        words.stream().sorted(Comparator.comparingInt(String::length)).forEach(x -> System.out.println("" + x));


        //Reduce operation: Given a list of integers, compute the sum of all the elements using the reduce function.
        //numbers.stream().reduce(0, (sub, total) -> sub + total); same results as below
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("" + sum);


        //Collecting elements: Given a list of strings, create a new list that contains the strings in uppercase and sorted by length using the collect function with Collectors.toList().
        List<String> upperCase = words.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        upperCase.forEach(x -> System.out.println("" + x));



    }


    Function<Integer, Integer> squared = num -> num * num;

    public static Function getSquared(){
        Function<Integer, Integer> squared = num -> num * num;
        return squared;
    }

    public static void collect(){

        User.defaultList().stream()
                .collect(Collectors.toMap(
                        User::getName, User::getLastName
                ))
                .forEach((k,v) -> System.out.println(k + v));

    }

}

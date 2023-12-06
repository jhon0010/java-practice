package core_concepts.concepts;


import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Class to practice regular expressions
 *
 * () = group example, like (A[MX]|M[ED]) stands for A followed by M or X or M followed by E or D group example
 *
 * [a-zA-Z]= any letter
 * {n,m} = n to m times occurrence of the previous character
 * {n,} = n or more times occurrence of the previous character
 * \w = any word character
 * \W = any non-word character
 * \\s = any white space character
 * \\S = any non-white space character
 * \\d = any digit
 * \\D = any non-digit
 *
 * + = one or more times occurrence of the previous character
 * ? = zero or one times occurrence of the previous character
 * * = zero or more times occurrence of the previous character
 *
 * . = any character except new line
 *
 *
 * Characters that you need to escape with a backslash are: .[]{}()*+-?^$|
 *
 */
public class RegularExpression {

    private static final Logger LOGGER = Logger.getLogger(RegularExpression.class.getName());

    public static void main(String[] args) {

        String s1 = "This is a test string with phone number 123-456-7890 lives in AMX and go to MED and email address johndoe@gmail.com, 123 456-7890 " +
                "from CA zipcode 12345 and 1Z aaa **** *** {{{ {{ { } [ ] another phone number pattern could be (555)666-1212 ";


        /**
         * Word that is between 2 and 20 characters long and its surrounded by white spaces
         * "\\w{2,20}"; // same as above
         */
        String pattern_word_length_spaces = "\\s[a-zA-Z]{2,20}\\s";
        //regexChecker(pattern_word_length_spaces, s1);

        /**
         * Zipcode that is 5 digits long and its surrounded by white spaces
         */
        String pattern_zip_code = "\\s\\d{5}\\s";
        regexChecker(pattern_zip_code, s1);

        /**
         * regex A[MX]|M[ED] stands for A followed by M or X or M followed by E or D group example
         */
        String lives = "A[MX]|M[ED]";
        regexChecker(lives,s1);

        /**
         * regex(\{{1,}) stands for one or more occurrences of the { character
         */
        String pattern_curly_braces = "(\\{+)";
        regexChecker(pattern_curly_braces, s1);

        /**
         * The pattern [a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+
         * stands for one or more occurrences of any letter or digit,followed by @,
         * followed by one or more occurrences of any letter or digit,
         * followed by ., followed by one or more occurrences of any letter or digit.
         */
        String pattern_email = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+";
        regexChecker(pattern_email, s1);

        /**
         * A pattern that will match any phone number like :
         *  123-456-7890 or (123)456-7890 or 123-456-7890 or 123 456-7890
         *
         * The patter ([0-9]( |-)?)?(\(?[0-9]{3}\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}) stands for:
         *  ([0-9]( |-)?)? = zero or one times occurrence of a digit followed by a space or a dash
         *  (\(?[0-9]{3}\)?|[0-9]{3}) = three digits could be surrounded by parenthesis
         *  ( |-)? = zero or one times occurrence of a space or a dash
         *  ([0-9]{3}( |-)?[0-9]{4}) = three digits followed by a space or a dash followed by four digits
         *
         */
        String pattern_phone_number = "([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4})";
        regexChecker(pattern_phone_number, s1);

        /**
         * This pattern \s+ stands for one or more occurrences of a white space character
         * This would be replace by a comma and a space
         */
        regexReplaceByPattern("\\s+", s1, ", ");


    }

    public static void special_cases(){
        // Ignore case, this is the same that [A-Za-z]
        Pattern ignore_cases = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE);
    }

    public static void regexReplaceByPattern(String theRegex, String str2Check, String replaceWith){

        Pattern replacePattern = Pattern.compile(theRegex);
        Matcher regexMatcher = replacePattern.matcher(str2Check.trim());
        LOGGER.info(regexMatcher.replaceAll(replaceWith));
    }


    public static void regexChecker(String theRegex, String str2Check) {

        Pattern pattern = Pattern.compile(theRegex);// Create the actual regex pattern object
        Matcher regexMatcher = pattern.matcher(str2Check); // Create a matcher object that will match the regex pattern to the string passed in

        //true if a subsequence of the input sequence matches this matcher's pattern
        while (regexMatcher.find()) {

            // Validate if the match is not empty (there are at least 1 match)
            if(regexMatcher.group().length() != 0) {
                LOGGER.info(regexMatcher.group().trim());
            }

            LOGGER.info("Start index: " + regexMatcher.start());
            LOGGER.info("End index: " + regexMatcher.end());
        }

    }


}

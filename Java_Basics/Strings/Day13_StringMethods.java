package Strings;

public class Day13_StringMethods {

    public static void main(String[] args) {

        String str = "Capgemini Training";

        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Substring: " + str.substring(0, 9));
        System.out.println("Contains 'Train': " + str.contains("Train"));
        System.out.println("Replace: " + str.replace("Training", "Program"));
    }
}
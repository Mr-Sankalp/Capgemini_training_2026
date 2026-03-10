package Strings;

public class Day5_StringBasics {

    public static void main(String[] args) {

        String str1 = "Java";
        String str2 = "Training";

        // Length
        System.out.println("Length: " + str1.length());

        // Concatenation
        String result = str1.concat(" ").concat(str2);
        System.out.println("Concatenated: " + result);

        // Immutability
        str1.concat(" Course");
        System.out.println("Original String: " + str1); // unchanged
    }
}
package String_Problems;

public class Day30_StringManipulation {

    public static void main(String[] args) {

        String str = "  Capgemini Training  ";

        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("Trimmed: " + str.trim());
        System.out.println("Contains 'Train': " + str.contains("Train"));
        System.out.println("Substring (0-9): " + str.substring(0, 9));
    }
}
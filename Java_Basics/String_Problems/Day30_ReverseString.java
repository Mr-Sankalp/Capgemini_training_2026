package String_Problems;

public class Day30_ReverseString {

    public static void main(String[] args) {

        String str = "Capgemini";
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Original: " + str);
        System.out.println("Reversed: " + reversed);
    }
}
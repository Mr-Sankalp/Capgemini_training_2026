package String_Problems;

public class Day30_BinaryString {

    public static void main(String[] args) {

        String binary = "1011";

        int decimal = Integer.parseInt(binary, 2);

        System.out.println("Binary: " + binary);
        System.out.println("Decimal: " + decimal);
    }
}
package basic_java;

public class Day3_Loops {

    public static void main(String[] args) {

        // For loop
        for (int i = 1; i <= 5; i++) {
            if (i == 3) continue;
            if (i == 5) break;
            System.out.println(i);
        }

        // Problem: Sum of first 5 numbers
        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            sum += i;
        }

        System.out.println("Sum: " + sum);
    }
}
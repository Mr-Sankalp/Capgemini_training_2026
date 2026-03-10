package basic_java;

public class Day2_OperatorsControl {

    public static void main(String[] args) {

        int a = 10, b = 5;

        // Arithmetic
        System.out.println("Addition: " + (a + b));
        System.out.println("Multiplication: " + (a * b));

        // Relational
        System.out.println("a > b: " + (a > b));

        // Assignment
        a += 5;
        System.out.println("New a: " + a);

        // Control Statement
        if (a > b) {
            System.out.println("a is greater");
        } else {
            System.out.println("b is greater");
        }
    }
}

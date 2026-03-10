package basic_java;

public class Day15_WrapperClass {

    public static void main(String[] args) {

        int a = 10;
        Integer obj = a;   // Autoboxing

        int b = obj;       // Unboxing

        System.out.println("Primitive: " + a);
        System.out.println("Wrapper Object: " + obj);
        System.out.println("Unboxed value: " + b);
    }
}
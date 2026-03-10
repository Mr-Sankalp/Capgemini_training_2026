package Strings;

public class Day6_StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println("StringBuilder: " + sb);

        StringBuffer sf = new StringBuffer("Java");
        sf.append(" OOPS");
        System.out.println("StringBuffer: " + sf);
    }
}
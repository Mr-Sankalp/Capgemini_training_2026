package Stack_Queue_Problems;

import java.util.Stack;

public class Day31_ReversePolishNotation {

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        System.out.println("Result: " + stack.pop());
    }
}
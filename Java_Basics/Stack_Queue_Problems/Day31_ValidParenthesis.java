package Stack_Queue_Problems;

import java.util.Stack;

public class Day31_ValidParenthesis {

    public static void main(String[] args) {

        String str = "{[()]}";
        Stack<Character> stack = new Stack<>();

        boolean valid = true;

        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {

                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    valid = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) valid = false;

        System.out.println("Valid Parenthesis: " + valid);
    }
}
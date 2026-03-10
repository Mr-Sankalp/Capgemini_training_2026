package Stack_Queue_Problems;

class CustomStack {

    int[] arr;
    int top;
    int capacity;

    CustomStack(int size) {
        capacity = size;
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }
}

public class Day31_ImplementStack {

    public static void main(String[] args) {

        CustomStack stack = new CustomStack(5);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
    }
}
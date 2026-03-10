package Stack_Queue_Problems;

class CustomQueue {

    int[] arr;
    int front, rear, size, capacity;

    CustomQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    void enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
    }

    int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }
}

public class Day32_QueueImplementation {

    public static void main(String[] args) {

        CustomQueue queue = new CustomQueue(5);
        queue.enqueue(10);
        queue.enqueue(20);

        System.out.println(queue.dequeue());
    }
}
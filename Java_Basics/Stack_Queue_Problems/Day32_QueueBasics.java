package Stack_Queue_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Day32_QueueBasics {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Front: " + queue.peek());
        System.out.println("Removed: " + queue.poll());
        System.out.println("Queue: " + queue);
    }
}
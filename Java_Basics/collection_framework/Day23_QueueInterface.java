package collection_framework;

import java.util.LinkedList;
import java.util.Queue;

public class Day23_QueueInterface {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();

        queue.add("Java");
        queue.add("Python");
        queue.add("SQL");

        System.out.println("Queue: " + queue);
        System.out.println("Removed: " + queue.poll());
        System.out.println("Peek: " + queue.peek());
    }
}
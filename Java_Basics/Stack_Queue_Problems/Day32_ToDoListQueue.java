package Stack_Queue_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Day32_ToDoListQueue {

    public static void main(String[] args) {

        Queue<String> tasks = new LinkedList<>();

        tasks.offer("Study DSA");
        tasks.offer("Practice Coding");
        tasks.offer("Revise Java");

        while (!tasks.isEmpty()) {
            System.out.println("Completed: " + tasks.poll());
        }
    }
}
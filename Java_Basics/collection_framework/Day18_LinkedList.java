package collection_framework;

import java.util.LinkedList;

public class Day18_LinkedList {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.addFirst(5);
        list.addLast(20);

        System.out.println("LinkedList: " + list);

        list.removeFirst();
        System.out.println("After removal: " + list);
    }
}
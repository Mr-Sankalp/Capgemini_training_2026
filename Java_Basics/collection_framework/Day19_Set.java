package collection_framework;

import java.util.HashSet;
import java.util.TreeSet;

public class Day19_Set {

    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(10); // duplicate ignored

        System.out.println("HashSet: " + hashSet);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(30);
        treeSet.add(5);
        treeSet.add(15);

        System.out.println("TreeSet (Sorted): " + treeSet);
    }
}
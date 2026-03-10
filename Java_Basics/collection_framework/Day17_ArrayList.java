package collection_framework;

import java.util.ArrayList;
import java.util.Iterator;

public class Day17_ArrayList {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // For loop
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // Enhanced for loop
        for (String lang : list) {
            System.out.println(lang);
        }

        // Iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
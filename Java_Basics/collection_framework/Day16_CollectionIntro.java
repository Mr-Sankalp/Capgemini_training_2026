package collection_framework;

import java.util.ArrayList;

public class Day16_CollectionIntro {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("SQL");

        for(String tech : list) {
            System.out.println(tech);
        }
    }
}
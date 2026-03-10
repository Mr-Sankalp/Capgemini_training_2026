package dsa_advance;

import java.util.*;

public class Day36_GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        System.out.println("Grouped Anagrams: " + map.values());
    }
}
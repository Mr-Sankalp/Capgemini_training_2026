package Searching_Sorting;

import java.util.HashSet;

public class Day35_DuplicatesWithinKDistance {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 1, 4, 5};
        int k = 3;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {

            if (set.contains(arr[i])) {
                System.out.println("Duplicate found within k distance");
                return;
            }

            set.add(arr[i]);

            if (i >= k)
                set.remove(arr[i - k]);
        }

        System.out.println("No duplicates within k distance");
    }
}
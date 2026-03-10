package Searching_Sorting;

import java.util.Arrays;

public class Day34_KthLargest {

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        Arrays.sort(arr);

        System.out.println("Kth Largest: " + arr[arr.length - k]);
    }
}
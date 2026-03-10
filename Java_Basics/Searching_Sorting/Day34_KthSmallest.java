package Searching_Sorting;

import java.util.Arrays;

public class Day34_KthSmallest {

    public static void main(String[] args) {

        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        Arrays.sort(arr);

        System.out.println("Kth Smallest: " + arr[k - 1]);
    }

    public static int[] maxandmin(int arr[]) {
        int n = arr.length;
        int max = 0;
        int min = 0;

        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return new int[]{max, min};
    }

    public static int secondlargest(int arr[]) {
        int n = arr.length;
        int max = -1;
        int sec_max = -1;

        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            } else if (sec_max < arr[i] && arr[i] != max) {
                sec_max = arr[i];
            }
        }
        return sec_max;
    }
}


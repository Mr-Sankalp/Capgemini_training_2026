package Array_Problems;

import java.util.Arrays;

public class Day29_RotateArray {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        int n = arr.length;

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[i] = arr[(i + d) % n];
        }

        System.out.println("Rotated Array: " + Arrays.toString(rotated));
    }
}

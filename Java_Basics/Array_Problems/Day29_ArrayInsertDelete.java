package Array_Problems;

import java.util.Arrays;

public class Day29_ArrayInsertDelete {

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        // INSERTION
        int position = 2;
        int element = 25;

        int[] newArr = new int[arr.length + 1];

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i == position) {
                newArr[i] = element;
            } else {
                newArr[i] = arr[j++];
            }
        }

        System.out.println("After Insertion: " + Arrays.toString(newArr));

        // DELETION
        int deletePos = 1;
        int[] deleteArr = new int[newArr.length - 1];

        for (int i = 0, j = 0; i < newArr.length; i++) {
            if (i != deletePos) {
                deleteArr[j++] = newArr[i];
            }
        }

        System.out.println("After Deletion: " + Arrays.toString(deleteArr));
    }
}
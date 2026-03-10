package Array_Problems;

public class Day29_SmallestElement {

    public static void main(String[] args) {

        int[] arr = {5, 8, 2, 10, 3};

        int smallest = arr[0];

        for (int num : arr) {
            if (num < smallest) {
                smallest = num;
            }
        }

        System.out.println("Smallest Element: " + smallest);
    }
}
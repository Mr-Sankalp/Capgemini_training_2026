package Array_Problems;

public class Day29_LargestElement {

    public static void main(String[] args) {

        int[] arr = {5, 8, 2, 10, 3};

        int largest = arr[0];

        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }

        System.out.println("Largest Element: " + largest);
    }
}
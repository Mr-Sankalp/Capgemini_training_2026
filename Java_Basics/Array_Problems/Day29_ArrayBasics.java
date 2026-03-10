package Array_Problems;

public class Day29_ArrayBasics {

    public static void main(String[] args) {

        // 1D Array
        int[] arr = {10, 20, 30, 40};

        System.out.println("1D Traversal:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        // 2D Array
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("2D Traversal:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
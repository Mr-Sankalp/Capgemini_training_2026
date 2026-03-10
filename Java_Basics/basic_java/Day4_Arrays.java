package basic_java;

public class Day4_Arrays {

    public static void main(String[] args) {

        // 1D Array
        int[] numbers = {10, 20, 30, 40};

        for (int num : numbers) {
            System.out.println(num);
        }

        // 2D Array
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Passing Array to Method
        printArray(numbers);
    }

    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }
}
package Searching_Sorting;

public class Day33_SquareRootInteger {

    public static void main(String[] args) {

        int x = 17;
        int left = 1, right = x;
        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (mid * mid == x) {
                System.out.println("Square Root: " + mid);
                return;
            }
            else if (mid * mid < x) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println("Square Root (floor): " + answer);
    }
}
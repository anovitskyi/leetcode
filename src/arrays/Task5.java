package arrays;

public class Task5 {

    // https://leetcode.com/problems/monotonic-array/

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int[] arr2 = {6, 5, 4, 4};
        int[] arr3 = {1, 3, 2};
        int[] arr4 = {1, 2, 4, 5};

        System.out.println(isMonotonic(arr));
        System.out.println(isMonotonic(arr2));
        System.out.println(isMonotonic(arr3));
        System.out.println(isMonotonic(arr4));
    }

    // O(n) time
    // O(1) space
    private static boolean isMonotonic(int[] A) {
        boolean up = false, down = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                down = true;
            } else if (A[i] < A[i + 1]) {
                up = true;
            }

            if (up && down) {
                return false;
            }
        }

        return true;
    }
}

package arrays;

public class Task4 {

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/

    public static void main(String[] args) {
        int[] arr = {0, 1, 0};
        System.out.println(peakIndexInMountainArray2(arr));
    }

    // O(n) time
    // O(1) space
    private static int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // O(log n) time
    // O(1) space
    private static int peakIndexInMountainArray2(int[] A) {
        if (A.length < 3) {
            return -1;
        }
        int left = 0, right = A.length - 1, middle;

        while (left <= right) {
            middle = (left + right) / 2;
            if (A[middle - 1] < A[middle] && A[middle] > A[middle + 1]) {
                return middle;
            } else if (A[middle] > A[middle + 1]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }

        }
        return -1;
    }

}

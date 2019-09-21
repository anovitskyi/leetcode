class Solution {
    public int peakIndexInMountainArray(int[] A) {
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
class Solution {
    public boolean isMonotonic(int[] A) {
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
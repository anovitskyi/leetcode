class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; ++i) {
            int length = A[i].length;
            for (int j = 0; j < length / 2; ++j) {
                int tmp = A[i][j];
                A[i][j] = 1 - A[i][length - 1 - j];
                A[i][length - 1 - j] = 1 - tmp;
            }
            
            if (length % 2 == 1) {
                A[i][length / 2] = 1 - A[i][length / 2];
            }
        }
        return A;
    }
}
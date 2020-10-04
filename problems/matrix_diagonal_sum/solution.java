class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        
        int colS = 0;
        int colE = mat.length - 1;
        for (int i = 0; i < mat.length; ++i) {
            sum += mat[i][colE--];
            sum += mat[i][colS++];
        }
        
        if (mat.length % 2 == 1) {
            int mid = mat.length / 2;
            sum -= mat[mid][mid];
        }
        
        return sum;
    }
}
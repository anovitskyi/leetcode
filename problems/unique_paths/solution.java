class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        dp(matrix, m - 1, n - 1);
        return matrix[m - 1][n - 1];
    }
    
    private void dp(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || (x == 0 && y == 0)) {
            return;
        }
        
        int prevX = 0;
        if (x - 1 >= 0) {
            if (matrix[x - 1][y] == 0) {
                dp(matrix, x - 1, y);
            }
            prevX = matrix[x - 1][y];
        }
        
        int prevY = 0;
        if (y - 1 >= 0) {
            if (matrix[x][y - 1] == 0) {
                dp(matrix, x, y - 1);
            }
            prevY = matrix[x][y - 1];
        }
        
        matrix[x][y] = prevX + prevY;
    }
}
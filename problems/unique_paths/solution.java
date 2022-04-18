class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        matrix[0][0] = 1;
        return findPaths(matrix, m - 1, n - 1);
    }
    
    private int findPaths(int[][] matrix, int row, int column) {
        if (row < 0 || column < 0) {
            return 0;
        }
        
        if (matrix[row][column] == 0) {
            matrix[row][column] = findPaths(matrix, row - 1, column) + findPaths(matrix, row, column - 1);
        }
        
        return matrix[row][column];
    }
}
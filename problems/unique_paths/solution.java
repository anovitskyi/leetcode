class Solution {
    public int uniquePaths(int m, int n) {
        return uniquePaths(m - 1, n - 1, new int[m][n]);
    }
    
    private int uniquePaths(int m, int n, int[][] arr) {
        if (m == 0 || n == 0) {
            arr[m][n] = 1;
            return 1;
        }
        
        if (arr[m][n] != 0) {
            return arr[m][n];
        }
        
        int tmp = uniquePaths(m - 1, n, arr) + uniquePaths(m, n - 1, arr);
        arr[m][n] = tmp;
        return tmp;
    }
}
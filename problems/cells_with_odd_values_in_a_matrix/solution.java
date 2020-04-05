class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        int counter = 0;
        
        for (int[] ind : indices) {
            int row = ind[0];
            int col = ind[1];
            
            for (int i = 0; i < m; ++i) {
                ++arr[row][i];
            }
            
            for (int i = 0; i < n; ++i) {
                ++arr[i][col];
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (arr[i][j] % 2 == 1) ++counter;
            }
        }
        
        return counter;
    }
}
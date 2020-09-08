class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; ++i) {
            int[] curr = matrix[i];
            int[] prev = matrix[i - 1];
            
            for (int j = 1; j < curr.length; ++j) {
                if (curr[j] != prev[j - 1]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}


// 8 9 3 1 4
// 6 8 9 3 1
// 7 6 8 9 3
// 1 7 6 8 9
// 2 1 7 6 8
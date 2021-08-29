class Solution {
    public void setZeroes(int[][] matrix) {
        boolean updateRows = false;
        boolean updateCols = false;
        
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    
                    if (i == 0) {
                        updateCols = true;
                    } 
                    
                    if (j == 0) {
                        updateRows = true;
                    }
                }
            }
        }
        
        for (int i = 1; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (updateRows) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][0] = 0;
            }
        }
        
        if (updateCols) {
            for (int j = 0; j < matrix[0].length; ++j) {
                matrix[0][j] = 0;
            }
        }
    }
}
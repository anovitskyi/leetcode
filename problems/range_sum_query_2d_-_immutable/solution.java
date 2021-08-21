class NumMatrix {
    
    private final int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 1; j < matrix[i].length; ++j) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
        
        for (int i = row1; i <= row2; ++i) {
            result += getSum(i, col1, col2);
        }
        
        return result;
    }
    
    private int getSum(int row, int col1, int col2) {
        if (col1 == 0) {
            return matrix[row][col2];
        }
        
        return matrix[row][col2] - matrix[row][col1 - 1];
    }
}
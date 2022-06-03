class NumMatrix {

    private final int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col = 1; col < row.length; ++col) {
                row[col] += row[col - 1];
            }
        }
        
        this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; ++row) {
            sum += getSumForRange(row, col1, col2);
        }
        return sum;
    }
    
    private int getSumForRange(int row, int start, int end) {
        int left = 0;
        if (start - 1 >= 0) {
            left = matrix[row][start - 1];
        }
        
        int right = matrix[row][end];
        
        return right - left;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
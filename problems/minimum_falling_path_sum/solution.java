class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int row = 1; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                int left = col > 0 ? matrix[row - 1][col - 1] : Integer.MAX_VALUE;
                int middle = matrix[row - 1][col];
                int right = col < matrix[row].length - 1 ? matrix[row - 1][col + 1] : Integer.MAX_VALUE;

                int min = Math.min(middle, Math.min(left, right));
                matrix[row][col] += min;
            }
        }

        int result = Integer.MAX_VALUE;
        int lastRow = matrix.length - 1;
        for (int col = 0; col < matrix[lastRow].length; ++col) {
            result = Math.min(result, matrix[lastRow][col]);
        }
        return result;
    }
}
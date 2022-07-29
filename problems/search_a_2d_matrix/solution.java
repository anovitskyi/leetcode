class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target, 0, matrix.length - 1);
        if (row < 0) {
            return false;
        }
        
        int col = findCol(matrix[row], target, 0, matrix[row].length - 1);
        if (col < 0) {
            return false;
        }
        
        return true;
    }
    
    private int findRow(int[][] matrix, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    private int findCol(int[] row, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}
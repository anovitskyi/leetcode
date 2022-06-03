class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        
        while (top <= bottom) {
            int middle = top + (bottom - top) / 2;
            
            if (matrix[middle][0] <= target && target <= matrix[middle][matrix[middle].length - 1]) {
                return elementExists(matrix[middle], target);
            } else if (matrix[middle][0] > target) {
                bottom = middle - 1;
            } else {
                top = middle + 1;
            }
        }
        
        return false;
    }
    
    private boolean elementExists(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (nums[middle] == target) {
                return true;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return false;
    }
}
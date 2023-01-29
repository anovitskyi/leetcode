class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row < 0) {
            return false;
        }

        int col = findCol(matrix[row], target);
        if (col < 0) {
            return false;
        }

        return true;
    }

    private int findRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length - 1]) {
                return mid;
            } else if (target < matrix[mid][0]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int findCol(int[] row, int target) {
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;

            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    } 
}
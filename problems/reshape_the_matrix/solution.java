class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int newSize = r * c;
        int oldSize = nums.length * nums[0].length;
        if (newSize != oldSize) {
            return nums;
        }
        
        int[][] arr = new int[r][c];
        
        int column = 0;
        int row = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                arr[i][j] = nums[row][column];
                if (++column >= nums[0].length) {
                    column = 0;
                    ++row;
                }
            }
        }
        
        return arr;
    }
}
class Solution {
    public int countNegatives(int[][] grid) {
        int result = 0;
        for (int[] level : grid) {
            result += findNegatives(level, 0, level.length - 1);
        }
        return result;
    }
    
    private int findNegatives(int[] level, int left, int right) {
        if (left > right) {
            return level.length - left;
        } 
        
        int middle = ((right - left) / 2) + left;
        if (level[middle] < 0) {
            return findNegatives(level, left, middle - 1);
        } else {
            return findNegatives(level, middle + 1, right);
        }
    }
}
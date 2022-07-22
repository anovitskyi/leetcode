class Solution {
    public int[] findBall(int[][] grid) {
        int[] result = new int[grid[0].length];
        
        for (int i = 0; i < result.length; ++i) {
            result[i] = findLastColumn(grid, 0, i);
        }
        
        return result;
    }
    
    private int findLastColumn(int[][] grid, int x, int y) {
        while (x < grid.length) {
            if (grid[x][y] == 1) {
                if (y + 1 >= grid[0].length || grid[x][y + 1] == -1) {
                    return -1;
                }
                
                ++y;
            } else {
                if (y == 0 || grid[x][y - 1] == 1) {
                    return -1;
                }
                
                --y;
            }
            
            ++x;
        }
        
        return y;
    }
}
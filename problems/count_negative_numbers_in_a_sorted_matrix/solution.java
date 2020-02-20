class Solution {
    public int countNegatives(int[][] grid) {
        int counter = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            counter += countNegatives(grid[i]);
        }
        
        return counter;
    }
    
    // private int countNegatives(int[] grid) {
    //     for (int i = 0; i < grid.length; ++i) {
    //         if (grid[i] < 0) {
    //             return grid.length - i; 
    //         }
    //     }
    //     return 0;
    // }
    
    private int countNegatives(int[] grid) {
        int start = 0;
        int end = grid.length;
        int mid, index = grid.length;
        
        while (start < end) {
            mid = (start + end) / 2;
            
            if (grid[mid] < 0) {
                index = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return grid.length - index;
    }
}
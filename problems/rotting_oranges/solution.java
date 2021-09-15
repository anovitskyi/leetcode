class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (isRotten(grid, i, j)) {
                    queue.offer(new int[] {i, j});
                } else if (isFresh(grid, i, j)) {
                    ++fresh;
                }
            }
        }
        
        if (fresh == 0 && queue.size() == 0) {
            return 0;
        }
        
        int result = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                int[] point = queue.poll();
                int i = point[0];
                int j = point[1];
                grid[i][j] = 2;
                
                if (isFresh(grid, i - 1, j)) {
                    queue.offer(new int[] {i - 1, j});
                    grid[i - 1][j] = 2;
                    --fresh;
                }
                
                if (isFresh(grid, i + 1, j)) {
                    queue.offer(new int[] {i + 1, j});
                    grid[i + 1][j] = 2;
                    --fresh;
                }
                
                if (isFresh(grid, i, j - 1)) {
                    queue.offer(new int[] {i, j - 1});
                    grid[i][j - 1] = 2;
                    --fresh;
                }
                
                if (isFresh(grid, i, j + 1)) {
                    queue.offer(new int[] {i, j + 1});
                    grid[i][j + 1] = 2;
                    --fresh;
                }
            }
            ++result;
        }
        
        if (fresh != 0) {
            return -1;
        }
        
        return result;
    }
    
    private boolean isRotten(int[][] grid, int i, int j) {
        return grid[i][j] == 2;
    }
    
    private boolean isFresh(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return false;
        }
        
        if (j < 0 || j >= grid[i].length) {
            return false;
        }
        
        return grid[i][j] == 1;
    }
    
    private boolean isEmpty(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) {
            return false;
        }
        
        if (j < 0 || j >= grid[i].length) {
            return false;
        }
        
        return grid[i][j] == 0;
    }
 }
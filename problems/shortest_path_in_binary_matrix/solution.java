class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int length = grid.length;
        if (grid[0][0] == 1 || grid[length - 1][length - 1] == 1) {
            return -1;
        }
        
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                if (grid[i][j] == 0) {
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    grid[i][j] = -1;
                }
            }
        }
        grid[0][0] = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (grid[x][y] == -1) {
                continue;
            }
            
            if (x + 1 < length && y + 1 < length && grid[x][y] + 1 < grid[x + 1][y + 1]) {
                grid[x + 1][y + 1] = grid[x][y] + 1;
                queue.offer(new int[] {x + 1, y + 1});
            }
         
            if (x + 1 < length && grid[x][y] + 1 < grid[x + 1][y]) {
                grid[x + 1][y] = grid[x][y] + 1;
                queue.offer(new int[] {x + 1, y});
            }
        
            if (y + 1 < length && grid[x][y] + 1 < grid[x][y + 1]) {
                grid[x][y + 1] = grid[x][y] + 1;
                queue.offer(new int[] {x, y + 1});
            }
        
            if (x + 1 < length && y - 1 >= 0 && grid[x][y] + 1 < grid[x + 1][y - 1]) {
                grid[x + 1][y - 1] = grid[x][y] + 1;
                queue.offer(new int[] {x + 1, y - 1});
            }
        
            if (x - 1 >= 0 && y + 1 < length && grid[x][y] + 1 < grid[x - 1][y + 1]) {
                grid[x - 1][y + 1] = grid[x][y] + 1;
                queue.offer(new int[] {x - 1, y + 1});
        }
        
            if (y - 1 >= 0 && grid[x][y] + 1 < grid[x][y - 1]) {
                grid[x][y - 1] = grid[x][y] + 1;
                queue.offer(new int[] {x, y - 1});
            }
        
            if (x - 1 >= 0 && grid[x][y] + 1 < grid[x - 1][y]) {
                grid[x - 1][y] = grid[x][y] + 1;
                queue.offer(new int[] {x - 1, y});
            }
        
            if (x - 1 >= 0 && y - 1 >= 0 && grid[x][y] + 1 < grid[x - 1][y - 1]) {
                grid[x - 1][y - 1] = grid[x][y] + 1;
                queue.offer(new int[] {x - 1, y - 1});
            }
        }
        
        if (grid[length - 1][length - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        
        return grid[length - 1][length - 1] + 1;
    }
}
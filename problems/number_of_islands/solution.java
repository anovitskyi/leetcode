class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    ++result;
                    visitIslandBfs(grid, i, j);
                }
            }
        }
        
        return result;
    }
    
    private void visitIslandDfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length) {
            return;
        }
        
        if (y < 0 || y >= grid[x].length) {
            return;
        }
        
        if (grid[x][y] == '0') {
            return;
        }
        
        grid[x][y] = '0';
        
        visitIslandDfs(grid, x - 1, y);
        visitIslandDfs(grid, x + 1, y);
        visitIslandDfs(grid, x, y - 1);
        visitIslandDfs(grid, x, y + 1);
    }
    
    private void visitIslandBfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (x < 0 || x >= grid.length) {
                continue;
            }
            
            if (y < 0 || y >= grid[x].length) {
                continue;
            }
            
            if (grid[x][y] == '0') {
                continue;
            }
            
            grid[x][y] = '0';
            
            queue.offer(new int[] {x - 1, y});
            queue.offer(new int[] {x + 1, y});
            queue.offer(new int[] {x, y - 1});
            queue.offer(new int[] {x, y + 1});
        }
    }
}
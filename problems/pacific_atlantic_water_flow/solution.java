class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificCells = getCellsThatCanReachPacificOcean(heights);
        boolean[][] atlanticCells = getCellsThatCanReachAtlanticOcean(heights);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; ++i) {
            for (int j = 0; j < heights[i].length; ++j) {
                if (pacificCells[i][j] && atlanticCells[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    private boolean[][] getCellsThatCanReachPacificOcean(int[][] grid) {
        boolean[][] result = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {0, 0});
        
        for (int i = 1; i < grid.length; ++i) {
            queue.offer(new int[] {i, 0});
        }
        
        for (int j = 1; j < grid[0].length; ++j) {
            queue.offer(new int[] {0, j});
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (result[x][y]) {
                continue;
            }
            
            result[x][y] = true;
            
            if (x - 1 >= 0 && grid[x - 1][y] >= grid[x][y]) {
                queue.offer(new int[] {x - 1, y});
            }
            
            if (y - 1 >= 0 && grid[x][y - 1] >= grid[x][y]) {
                queue.offer(new int[] {x, y - 1});
            }
            
            if (x + 1 < grid.length && grid[x + 1][y] >= grid[x][y]) {
                queue.offer(new int[] {x + 1, y});
            }
            
            if (y + 1 < grid[x].length && grid[x][y + 1] >= grid[x][y]) {
                queue.offer(new int[] {x, y + 1});
            }
        }
        
        return result;
    }
    
    private boolean[][] getCellsThatCanReachAtlanticOcean(int[][] grid) {
        boolean[][] result = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {grid.length - 1, grid[0].length - 1});
        
        for (int i = 0; i < grid.length - 1; ++i) {
            queue.offer(new int[] {i, grid[i].length - 1});
        }
        
        for (int j = 0; j < grid[0].length - 1; ++j) {
            queue.offer(new int[] {grid.length - 1, j});
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (result[x][y]) {
                continue;
            }
            
            result[x][y] = true;
            
            if (x - 1 >= 0 && grid[x - 1][y] >= grid[x][y]) {
                queue.offer(new int[] {x - 1, y});
            }
            
            if (y - 1 >= 0 && grid[x][y - 1] >= grid[x][y]) {
                queue.offer(new int[] {x, y - 1});
            }
            
            if (x + 1 < grid.length && grid[x + 1][y] >= grid[x][y]) {
                queue.offer(new int[] {x + 1, y});
            }
            
            if (y + 1 < grid[x].length && grid[x][y + 1] >= grid[x][y]) {
                queue.offer(new int[] {x, y + 1});
            }
        }
        
        return result;
    }
}
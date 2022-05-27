class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    ++freshOranges;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int beforeTraversal = freshOranges;
            
            while (size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                if (grid[x][y] == 1) {
                    grid[x][y] = 2;
                    --freshOranges;
                }
                
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[] {x - 1, y});
                }
                
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    queue.offer(new int[] {x + 1, y});
                }
                
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[] {x, y - 1});
                }
                
                if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
                    queue.offer(new int[] {x, y + 1});
                }
            }
            
            if (freshOranges != beforeTraversal) {
                ++result;
            }
        }
        
        return freshOranges != 0 ? -1 : result;
    }
    
}
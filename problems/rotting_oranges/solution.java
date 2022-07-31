class Solution {
    public int orangesRotting(int[][] grid) {
        int result = 0;
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 0) {
                    continue;
                } else if (grid[i][j] == 1) {
                    ++freshOranges;
                } else {
                    rottenOranges.offer(new int[] {i, j});
                }
            }
        }
        
        while (freshOranges > 0 && !rottenOranges.isEmpty()) {
            int before = freshOranges;
            int size = rottenOranges.size();
            
            while (size-- > 0) {
                int[] poll = rottenOranges.poll();
                int x = poll[0];
                int y = poll[1];
                
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    --freshOranges;
                    grid[x - 1][y] = 2;
                    rottenOranges.offer(new int[] {x - 1, y});
                }
                
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    --freshOranges;
                    grid[x + 1][y] = 2;
                    rottenOranges.offer(new int[] {x + 1, y});
                }
                
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    --freshOranges;
                    grid[x][y - 1] = 2;
                    rottenOranges.offer(new int[] {x, y - 1});
                }
                
                if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
                    --freshOranges;
                    grid[x][y + 1] = 2;
                    rottenOranges.offer(new int[] {x, y + 1});
                }
            }
            
            if (before == freshOranges) {
                return -1;
            }
            
            ++result;
        }
        
        if (freshOranges > 0 && rottenOranges.isEmpty()) {
            return -1;
        }
        
        return result;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    ++freshOranges;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        if (freshOranges == 0) {
            return 0;
        }
        
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int before = freshOranges;
            
            while (size-- > 0) {
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                
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
            
            if (freshOranges != before) {
                ++minutes;  
            } 
        }
        
        if (freshOranges > 0) {
            return -1;
        }
        
        return minutes;
    }
}

/*

    [[2,2],
     [1,1],
     [0,0],
     [2,0]]


*/
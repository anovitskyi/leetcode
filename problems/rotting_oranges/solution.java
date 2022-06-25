class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    ++freshOranges;
                    if (isSurroundedByRottenOrange(grid, i, j)) {
                        queue.offer(new int[] {i, j});   
                    }
                }
            }
        }
        
        int result = 0;
        while (!queue.isEmpty()) {
            int beforeChange = freshOranges;
            
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                if (grid[x][y] != 1) {
                    continue;
                }
                
                grid[x][y] = 2;
                --freshOranges;
                
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    queue.offer(new int[] {x - 1, y});
                }
                
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    queue.offer(new int[] {x, y - 1});
                }
                
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    queue.offer(new int[] {x + 1, y});
                }
                
                if (y + 1 < grid[x].length && grid[x][y + 1] == 1) {
                    queue.offer(new int[] {x, y + 1});
                }
            }
            
            if (freshOranges < beforeChange) {
                ++result;   
            } else {
                break;
            }
        }
        
        if (freshOranges != 0) {
            return -1;
        }
        return result;
    }
    
    private boolean isSurroundedByRottenOrange(int[][] grid, int i, int j) {
        if (i - 1 >= 0 && grid[i - 1][j] == 2) {
            return true;
        }
        
        if (j - 1 >= 0 && grid[i][j - 1] == 2) {
            return true;
        }
        
        if (i + 1 < grid.length && grid[i + 1][j] == 2) {
            return true;
        }
        
        if (j + 1 < grid[i].length && grid[i][j + 1] == 2) {
            return true;
        }
        
        return false;
    }
}

/*


[[2,1,1],[1,1,0],[0,1,1]]

 2 2 1
 2 1 0
 0 1 1

*/
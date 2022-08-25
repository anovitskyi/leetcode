class Solution {
    
    private static final int[][] directions;
    
    static {
        int[][] tmp = {
            {1, 1},
            {1, 0},
            {0, 1},
            {1, -1},
            {-1, 1},
            {-1, 0},
            {0, -1},
            {-1, -1}
        };
        directions = tmp;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                
                if (x < 0 || x >= grid.length) {
                    continue;
                }
                
                if (y < 0 || y >= grid[x].length) {
                    continue;
                }
                
                if (grid[x][y] == 1) {
                    continue;
                }
                grid[x][y] = 1;
                
                if (x == grid.length - 1 && y == grid[x].length - 1) {
                    return result;
                }
                
                for (int[] dir : directions) {
                    queue.offer(new int[] {x + dir[0], y + dir[1]});
                }
            }
            ++result;
        }
        return -1;
    }
}
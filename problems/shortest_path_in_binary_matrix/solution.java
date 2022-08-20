class Solution {
    private static final int[][] directions;
    
    static {
        int[][] copy = {
            {1, 1},
            {0, 1},
            {1, 0},
            {-1, 1},
            {1, -1},
            {-1, 0},
            {0, -1},
            {-1, -1}
        };
        
        directions = copy;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int destX = grid.length - 1;
        int destY = grid[0].length - 1;
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
                if (x == destX && y == destY) {
                    return result;
                }
                grid[x][y] = 1;
                
                for (int[] dir : directions) {
                    queue.offer(new int[] {x + dir[0], y + dir[1]});
                }
            }
            ++result;
        }
        
        return -1;
    }
    
}
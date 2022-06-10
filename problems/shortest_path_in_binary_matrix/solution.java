class Solution {
    
    private static final int[][] directions = {
        {1, 1},
        {1, 0},
        {0, 1},
        {-1, 1},
        {1, -1},
        {0, -1},
        {-1, 0},
        {-1, -1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int result = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++result;
            
            while (size-- > 0) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                
                if (x < 0 || x >= grid.length || y < 0 || y >= grid.length || grid[x][y] == 1) {
                    continue;
                }
                
                grid[x][y] = 1;
                
                if (x == grid.length - 1 && y == grid.length - 1) {
                    return result;
                }
                
                for (int[] dir : directions) {
                    queue.offer(new int[] {x + dir[0], y + dir[1]});
                }
            }
        }
        
        return -1;
    }
}
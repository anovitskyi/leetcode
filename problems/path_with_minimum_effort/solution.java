class Solution {
    
    private static final int[][] directions = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };
    
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        if(rows == 1 && cols == 1) {
            return 0;
        }
        
        int efforts[][] = new int[rows][cols];
        for (int row[] : efforts) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((t1, t2) -> (t1[2] - t2[2]));
        queue.offer(new int[] {0, 0, 0});
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int effort = curr[2];
            
            for(int[] direction : directions) {
                int newRow = row + direction[0];
                if (newRow < 0 || newRow >= rows) {
                    continue;
                }
                
                int newCol = col + direction[1];
                if (newCol < 0 || newCol >= cols) {
                    continue;
                }
                
                int newEffort = Math.max(effort, Math.abs(heights[newRow][newCol] - heights[row][col]));
                
                if (newEffort < efforts[newRow][newCol]) {
                    efforts[newRow][newCol] = newEffort;
                    queue.offer(new int[]{newRow, newCol, newEffort});
                }
                
            }
        }
        
        return efforts[rows - 1][cols - 1];
    }
}
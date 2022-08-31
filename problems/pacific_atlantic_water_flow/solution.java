class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = findPacificMountains(heights);
        boolean[][] atlantic = findAtlanticMountains(heights);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; ++i) {
            for (int j = 0; j < heights[i].length; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }
    
    private boolean[][] findPacificMountains(int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < heights[0].length; ++i) {
            queue.offer(new int[] {0, i});
        }
        for (int i = 1; i < heights.length; ++i) {
            queue.offer(new int[] {i, 0});
        }
        return populateTab(heights, queue);
    }
    
    private boolean[][] findAtlanticMountains(int[][] heights) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < heights[heights.length - 1].length; ++i) {
            queue.offer(new int[] {heights.length - 1, i});
        }
        for (int i = 0; i < heights.length - 1; ++i) {
            queue.offer(new int[] {i, heights[i].length - 1});
        }
        return populateTab(heights, queue);
    }
    
    private boolean[][] populateTab(int[][] heights, Queue<int[]> queue) {
        boolean[][] result = new boolean[heights.length][heights[0].length];
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (result[x][y]) {
                continue;
            }
            result[x][y] = true;
            
            if (x - 1 >= 0 && heights[x - 1][y] >= heights[x][y]) {
                result[x][y] = true;
                queue.offer(new int[] {x - 1, y});
            }
            
            if (x + 1 < heights.length && heights[x + 1][y] >= heights[x][y]) {
                result[x][y] = true;
                queue.offer(new int[] {x + 1, y}); 
            }
            
            if (y - 1 >= 0 && heights[x][y - 1] >= heights[x][y]) {
                result[x][y] = true;
                queue.offer(new int[] {x, y - 1});
            }
            
            if (y + 1 < heights[x].length && heights[x][y + 1] >= heights[x][y]) {
                result[x][y] = true;
                queue.offer(new int[] {x, y + 1});
            }
        }
        return result;
    }
}
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int counter = 0;
        
        for (int i = 0; i < points.length - 1; ++i) {
            int[] from = points[i];
            int[] to = points[i + 1];
            
            int x = Math.abs(to[0] - from[0]);
            int y = Math.abs(to[1] - from[1]);
            
            counter += Math.max(x, y);
        }
        
        return counter;
    }
    
    
}
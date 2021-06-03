class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; ++i) {
            result[i] = findIntersections(points, queries[i]);
        }
        
        return result;
    }
    
    private int findIntersections(int[][] points, int[] query) {
        double currDistance = findDistance(query[0], query[1], query[0] + query[2], query[1]);
        
        int intersections = 0;
        for (int[] point : points) {
            if (findDistance(query[0], query[1], point[0], point[1]) <= currDistance) {
                ++intersections;
            }
        }
        return intersections;
    }
    
    private double findDistance(int x1, int y1, int x2, int y2) {
        int xDiff = (int) Math.pow(x2 - x1, 2);
        int yDiff = (int) Math.pow(y2 - y1, 2);
        
        return Math.sqrt(xDiff + yDiff);
    }
}
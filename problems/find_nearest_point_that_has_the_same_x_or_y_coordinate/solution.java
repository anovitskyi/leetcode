class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int result = -1;
        int sum = Integer.MAX_VALUE;
        
        for (int i = points.length - 1; i >= 0; --i) {
            if (points[i][0] == x || points[i][1] == y) {
                int newSum = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (newSum <= sum) {
                    sum = newSum;
                    result = i;
                }
            }
        }
        
        return result;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 0;
        
        for (int i = 0; i < points.length; ++i) {
            int j = i + 1;

            while (j < points.length && points[j][0] <= points[i][1]) {
                ++j;
            }

            ++result;
            if (j > i + 1) {
                i = j - 1;
            }
        }
        
        return result;
    }
}

/**

    [-1,1],[0,1],[1,2],[2,3]





 */
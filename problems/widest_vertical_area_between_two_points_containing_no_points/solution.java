class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < points.length; ++i) {
            result = Math.max(result, points[i][0] - points[i - 1][0]);
        }
        return result;
    }
}

/*
    [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]

    1 3 5 8 9
    1


 */
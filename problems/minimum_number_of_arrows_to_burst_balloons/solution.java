class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            int startDiff = Integer.compare(a[0], b[0]);
            if (startDiff != 0) {
                return startDiff;
            }

            return b[1] - a[1];
        });

        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            int[] balloon = points[i];
            while (i + 1 < points.length && points[i + 1][0] <= balloon[1]) {
                balloon[0] = Math.max(balloon[0], points[i + 1][0]);
                balloon[1] = Math.min(balloon[1], points[i + 1][1]);
                ++i;
            }
            ++result;
        }
        return result;
    }
}
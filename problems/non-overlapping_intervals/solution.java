class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int result = 0;
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                ++result;
                intervals[i] = intervals[i - 1];
            }
        }
        return result;
    }
}

/**

    [-73,-26],[-65,-11],[-63,2],[-62,-49],[-52,31],[-40,-26],[-31,49],[30,47],[58,95],[66,98],[82,97],[95,99]

    ----------

    [-62,-49],[-73,-26],[-40,-26],[-65,-11],[-63,2],[-52,31],[30,47],[-31,49],[58,95],[82,97],[66,98],[95,99]


    counter = 7
    [-62,-49],[-40,-26],[30,47],[58,95],[95,99]
 */
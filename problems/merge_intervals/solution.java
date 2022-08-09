class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            
            return a[0] - b[0];
        });
        
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] > prev[1]) {
                prev = intervals[i];
                result.add(intervals[i]);
            } else if (intervals[i][1] > prev[1]) {
                prev[1] = intervals[i][1];
            }
        }
        
        int[][] r = new int[result.size()][2];
        for (int i = 0; i < result.size(); ++i) {
            r[i] = result.get(i);
        }
        return r;
    }
}
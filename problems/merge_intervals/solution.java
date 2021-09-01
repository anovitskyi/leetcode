class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        int[] last = intervals[0];
        
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= last[1]) {
                if (intervals[i][1] > last[1]) {
                    last[1] = intervals[i][1];
                }
            } else {
                result.add(intervals[i]);
                last = intervals[i];
            }    
        }
        
        return result.toArray(new int[result.size()][2]);
    }
}
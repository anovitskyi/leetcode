class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int first = Integer.compare(a[0], b[0]);
            
            if (first == 0) {
                return Integer.compare(a[1], b[1]);
            }
            
            return first;
        });
        
        List<int[]> result = new LinkedList<>();
        int[] last = intervals[0];
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] > last[1]) {
                result.add(intervals[i]);
                last = intervals[i];
            } else if (intervals[i][1] > last[1]) {
                last[1] = intervals[i][1];
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
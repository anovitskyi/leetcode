class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int diff = a[0] - b[0];
            
            if (diff == 0) {
                return a[1] - b[1];
            }
            
            return diff;
        });
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];
            
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                list.add(curr);
            }
        }
        
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
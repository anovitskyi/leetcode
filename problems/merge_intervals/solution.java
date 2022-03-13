class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> resultList = new ArrayList<>();
        resultList.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] prevIntervals = resultList.get(resultList.size() - 1);
            if (intervals[i][0] > prevIntervals[1]) {
                resultList.add(intervals[i]);
                continue;
            }
            
            //prevIntervals[0] = Math.min(prevIntervals[0], intervals[i][0]);
            prevIntervals[1] = Math.max(prevIntervals[1], intervals[i][1]);
        }
        
        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); ++i) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
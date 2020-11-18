class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        
        sortArray(intervals);
        
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] <= stack.peek()[1]) {
                if (intervals[i][1] > stack.peek()[1]) {
                    stack.peek()[1] = intervals[i][1];
                }
            } else {
                stack.push(intervals[i]);
            }
        }
        
        int[][] result = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return result;
    }
    
    private void sortArray(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            int first = Integer.compare(a[0], b[0]);
            
            if (first == 0) {
                return Integer.compare(a[1], b[1]);
            }
            
            return first;
        });
    }
}
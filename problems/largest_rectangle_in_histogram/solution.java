class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; ++i) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] data = stack.pop();
                int dist = data[1] * (i - data[0]);

                if (dist > result) {
                    result = dist;
                }
                start = data[0];
            }
            stack.push(new int[] {start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] data = stack.pop();
            int dist = data[1] * (heights.length - data[0]);

            if (dist > result) {
                result = dist;
            }
        }

        return result;
    }
}
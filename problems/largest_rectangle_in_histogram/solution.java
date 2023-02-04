class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < heights.length; ++i) {
            int lastIndex = i;

            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] tab = stack.pop();
                
                int length = tab[1] * (i - tab[0]);
                if (length > result) {
                    result = length;
                }

                lastIndex = tab[0];
            }

            stack.push(new int[] {lastIndex, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] tab = stack.pop();
            
            int length = tab[1] * (heights.length - tab[0]);
            if (length > result) {
                result = length;
            }
        }

        return result;
    }
}
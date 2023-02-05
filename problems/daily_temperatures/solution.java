class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[i] >= stack.peek()[0]) {
                stack.pop();
            }

            int daysToWait = 0;
            if (!stack.isEmpty()) {
               daysToWait = stack.peek()[1] - i;
            }

            result[i] = daysToWait;
            stack.push(new int[]{temperatures[i], i});
        }

        return result;
    }
}
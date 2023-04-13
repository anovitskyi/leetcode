class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int poppedRead = 0;
        Stack<Integer> stack = new Stack<>();

        for (int pushedNumber : pushed) {
            stack.push(pushedNumber);

            while (!stack.isEmpty() && poppedRead < popped.length && stack.peek() == popped[poppedRead]) {
                stack.pop();
                ++poppedRead;
            }
        }

        return stack.isEmpty();
    }
}
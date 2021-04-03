class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        
        for (int push : pushed) {
            stack.push(push);
            
            while (stack.size() > 0 && popIndex < popped.length && popped[popIndex] == stack.peek()) {
                ++popIndex;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
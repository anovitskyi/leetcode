class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }

        char[] result = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
}
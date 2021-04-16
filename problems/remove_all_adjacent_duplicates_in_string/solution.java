class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); ++i) {
            if (stack.isEmpty() || stack.peek() != S.charAt(i)) {
                stack.push(S.charAt(i));
            } else {
                stack.pop();
            }
        }
        
        char[] res = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; --i) {
            res[i] = stack.pop();
        }
        return new String(res, 0, res.length);
    }
}
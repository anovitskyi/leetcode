class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (stack.isEmpty()) {
                return false;
            } else {
                char pop = stack.pop();
                if (ch == ')' && pop != '(' || ch == ']' && pop != '[' || ch == '}' && pop != '{') {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
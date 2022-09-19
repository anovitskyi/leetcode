class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }
            
            if (stack.isEmpty()) {
                return false;
            }
            
            char peek = stack.peek();
            if ((ch == ')' && peek != '(') || (ch == ']' && peek != '[') || (ch == '}' && peek != '{')) {
                return false;
            }
            stack.pop();
        }
        
        return stack.isEmpty();
    }
}
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            if (isOpenBracket(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) {
                return false;
            } else if (isCloseBracket(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                return false;
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isOpenBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
    
    private boolean isCloseBracket(char peek, char ch) {
        return (ch == ']' && peek == '[') || (ch == '}' && peek == '{') || (ch == ')' && peek == '(');
    }
}
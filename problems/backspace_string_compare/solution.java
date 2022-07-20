class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = convertToStack(s);
        Stack<Character> tStack = convertToStack(t);
        
        if (sStack.size() != tStack.size()) {
            return false;
        }
        
        while (!sStack.isEmpty()) {
            if (sStack.pop() != tStack.pop()) {
                return false;
            }
        }
        
        return true;
    }
    
    private Stack<Character> convertToStack(String word) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) != '#') {
                stack.push(word.charAt(i));
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        
        return stack;
    }
}
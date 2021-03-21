class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sStack = convertToStack(S);
        Stack<Character> tStack = convertToStack(T);
        
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
        int index = 0;
        
        while (index < word.length()) {
            
            if (word.charAt(index) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(word.charAt(index));
            }
            ++index;
            
            
        }
        
        return stack;
    }
}
class Solution {
    public String removeDuplicates(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            
            if (ch == stack.peek()) {
                stack.pop();
            } else { 
                stack.push(ch);
            }
        }
        
        char[] tab = new char[stack.size()];
        for (int i = stack.size() - 1; stack.size() > 0; --i) {
            tab[i] = stack.pop();
        }
        return new String(tab);
        
    }
}
class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int current = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                ++current;
                max = Math.max(max, current);
            } else if (ch == ')') {
                --current;
            }
        }
        
        return max;
    }
    
    
}
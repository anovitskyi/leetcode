class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        int size = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            if (stack.isEmpty() || stack.peek().character != ch) {
                stack.push(new Pair(ch));
                ++size;
            } else if (stack.peek().counter < k - 1) {
                ++stack.peek().counter;
                ++size;
            } else {
                stack.pop();
                size -= k - 1;
            }
        }
        
        char[] res = new char[size];
        for (int i = size - 1; i >= 0;) {
            Pair pair = stack.pop();
            while (pair.counter-- > 0) {
                res[i--] = pair.character;
            }
        }
        return new String(res, 0, size);
    }
    
    private class Pair {
        final char character;
        int counter;
        
        Pair(char character) {
            this.character = character;
            this.counter = 1;
        }
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperation(token)) {
                stack.push(operate(token, stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }
    
    private boolean isOperation(String token) {
        return token.length() == 1 && token.charAt(0) < 48;
    }
    
    private int operate(String token, int b, int a) {
        if ("+".equals(token)) {
            return a + b;
        } else if ("-".equals(token)) {
            return a - b;
        } else if ("*".equals(token)) {
            return a * b;
        } else if ("/".equals(token)) {
            return a / b;
        }
        
        throw new IllegalArgumentException("unknown operation character");
    }
}
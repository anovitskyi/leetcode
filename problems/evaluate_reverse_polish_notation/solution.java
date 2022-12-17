class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int solution = solve(token, a, b);

                stack.push(solution);
            } else {
                int operand = Integer.parseInt(token);

                stack.push(operand);
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        char f = token.charAt(0);

        return token.length() == 1 && (f == '+' || f == '-' || f == '*' || f == '/');
    }

    private int solve(String token, int a, int b) {
        switch (token) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b;
            default: throw new UnsupportedOperationException(token);
        }
    }
}
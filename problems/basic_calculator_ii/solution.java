class Solution {
    
    private static final Set<Character> operatorsSet = Set.of('+', '-', '*', '/');
    
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();
        
        for (int i = 0; i < s.length(); ++i) {
            if (isDigit(s.charAt(i))) {
                int prev = i > 0 && isDigit(s.charAt(i - 1)) ? numbers.pop() : 0;
                int curr = s.charAt(i) - '0';
                numbers.push(prev * 10 + curr);
            } else if (isOperator(s.charAt(i))) {
                char operator = s.charAt(i);
                while (!operators.isEmpty() && getOperatorLevel(operators.peek()) >= getOperatorLevel(operator)) {
                    int b = numbers.pop();
                    char prevOperator = operators.pop();
                    int a = numbers.pop();
                    numbers.push(calculate(a, prevOperator, b));
                }
                operators.push(operator);
            }
        }
        
        while (!operators.isEmpty()) {
            int b = numbers.pop();
            char operator = operators.pop();
            int a = numbers.pop();
            numbers.push(calculate(a, operator, b));
        }
        return numbers.pop();
    }
    
    
    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
    
    private boolean isOperator(char ch) {
        return operatorsSet.contains(ch);
    }
    
    private int getOperatorLevel(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
    
    private int calculate(int a, char operator, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
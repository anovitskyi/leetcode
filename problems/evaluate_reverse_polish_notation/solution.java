class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                numbers.push(convertToNumber(token));
            } else {
                int second = numbers.pop();
                int first = numbers.pop();
                char operation = token.charAt(0);

                int result = eval(first, operation, second);

                numbers.push(result);
            }
        }

        return numbers.pop();
    }

    private int convertToNumber(String token) {
        int index = 0;
        int result = 0;

        if (token.charAt(0) == '-') {
            ++index;
        }

        while (index < token.length()) {
            int last = token.charAt(index) - '0';
            result = result * 10 + last;
            ++index;
        }

        return token.charAt(0) == '-' ? result * -1 : result;
    }

    private int eval(int first, char operation, int second) {
        switch (operation) {
            case '+': return first + second;
            case '-': return first - second;
            case '*': return first * second;
            case '/': return first / second;
        }

        return -1;
    }

    private boolean isNumber(String token) {
        return Character.isDigit(token.charAt(0)) || (token.length() > 1 && Character.isDigit(token.charAt(1))); 
    }
}
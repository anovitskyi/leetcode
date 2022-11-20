class Solution {
    public int calculate(String s) {
        int result = 0;
        int sign = 1;

        Stack<Integer> numbers = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int curr = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                     curr = curr * 10 + (s.charAt(i) - '0');
                     i++;
                }
                i--;
                curr = curr * sign;
                sign = 1;
                result += curr;   
            } else if (ch == '(') {
                numbers.push(result);
                numbers.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result *= numbers.pop();
                result += numbers.pop();
            } else if (ch == '-') {
                sign *= -1;
            }
        }

        return result;
    }
}
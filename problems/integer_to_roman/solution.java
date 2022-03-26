class Solution {
    
    private static final char[] LEVELS = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int level = -2;
        
        while (num > 0) {
            stack.push(num % 10);
            num /= 10;
            level += 2;
        }
        
        while (!stack.isEmpty()) {
            int digit = stack.pop();
            if (digit != 0) {
                builder.append(convertIntToRoman(digit, level));
            }
            level -= 2;
        }
        
        return builder.toString();
    }
    
    private String convertIntToRoman(int digit, int level) {
        StringBuilder builder = new StringBuilder();
        
        if (digit >= 1 && digit <= 3) {
            while (digit-- > 0) {
                builder.append(LEVELS[level]);
            }
        } else if (digit == 4) {
            builder.append(LEVELS[level]).append(LEVELS[level + 1]);
        } else if (digit == 5) {
            builder.append(LEVELS[level + 1]);
        } else if (digit >= 5 && digit <= 8) {
            builder.append(LEVELS[level + 1]);
            while (digit-- > 5) {
                builder.append(LEVELS[level]);
            }
        } else if (digit == 9) {
            builder.append(LEVELS[level]).append(LEVELS[level + 2]);
        } else if (digit == 0) {
            builder.append(LEVELS[level + 2]);
        }
        
        return builder.toString();
    }
}
class Solution {
    public int myAtoi(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        int startIndex = ignoreWhitespaces(s, 0);   
        if (startIndex >= s.length()) {
            return 0;
        }
        
        long result = 0L;
        boolean isNegative = false;
        if (s.charAt(startIndex) == '+') {
            ++startIndex;
        } else if (s.charAt(startIndex) == '-') {
            isNegative = true;
            ++startIndex;
        }
        
        for (int i = startIndex; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }
            
            result = result * 10 + (ch - '0');
            
            if (result > Integer.MAX_VALUE) {
                return convertToEdgeCases(result, isNegative);
            }
        }
        
        if (isNegative && result != 0) {
            result *= -1;
        }
        
        return (int) result;
    }
    
    private int ignoreWhitespaces(String s, int startIndex) {
        while (startIndex < s.length() && s.charAt(startIndex) == ' ') {
            ++startIndex;
        }
        
        return startIndex;
    }
    
    private int convertToEdgeCases(long result, boolean isNegative) {
        if (isNegative) {
            return Integer.MIN_VALUE;
        } else {
            return Integer.MAX_VALUE;
        }
    }
}
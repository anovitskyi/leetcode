class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (true) {
            while (left < s.length() && !isAlphaNumeric(s.charAt(left))) {
                ++left;
            }
            
            while (right >= 0 && !isAlphaNumeric(s.charAt(right))) {
                --right;
            }
            
            if (left >= right) {
                return true;
            } else if (!compareLowerCase(s.charAt(left++), s.charAt(right--))) {
                return false;
            }
        }
    }
    
    private boolean isAlphaNumeric(char ch) {
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        
        return ch >= 'a' && ch <= 'z';
    }
    
    private boolean compareLowerCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }
        
        if (b >= 'A' && b <= 'Z') {
            b += 32;
        }
        
        return a == b;
    }
}
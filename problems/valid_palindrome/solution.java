class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
                if (left >= s.length()) {
                    return true;
                }
            }
            
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                --right;
                if (right < 0) {
                    return true;
                }
            }
            
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            
            ++left;
            --right;
        }
        
        return true;
    }
}
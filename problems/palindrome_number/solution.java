class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int origin = x;
        int copy = 0;
        
        while (x != 0) {
            copy *= 10;
            copy += x % 10;
            x /= 10;
        }
        
        return origin == copy;
    }
}
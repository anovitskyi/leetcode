class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        
        int copy = x;
        int tmp = 0;
        
        while (copy > 0) {
            tmp = tmp * 10 + (copy % 10);
            copy /= 10;
        }
        
        return tmp == x;
    }
}
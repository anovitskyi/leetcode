class Solution {
    public boolean isPalindrome(int x) {  
        int copy = x;
        int reverse = 0;
        
        while (copy > 0) {
            reverse = reverse * 10 + copy % 10;
            copy = copy / 10;
        }
        
        return reverse == x;
    }
}
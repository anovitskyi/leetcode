class Solution {
    public int numberOfMatches(int n) {
        int result = 0;
        
        while (n > 1) {
            result += n / 2;
            int rest = n % 2;
            n /= 2;
            n += rest;
        }
        
        
        return result;
    }
}
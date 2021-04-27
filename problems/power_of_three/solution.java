class Solution {
    public boolean isPowerOfThree(int n) {
        int pow = 1;
        
        while (pow > 0 && pow <= n) {
            if (pow == n) {
                return true;
            }
            
            pow *= 3;
        }
        
        return false;
    }
}
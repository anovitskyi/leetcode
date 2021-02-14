class Solution {
    public boolean isPowerOfTwo(int n) {
        for (int i = 1; i > 0 && i <= n; i = i << 1) {
            if (i == n) {
                return true;
            }
        }
        
        return false;
    }
}

// log 2 n  = x
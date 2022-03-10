class Solution {
    
    private static final int[] cache = new int[46];
    
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        
        if (cache[n - 1] == 0) {
            cache[n - 1] = climbStairs(n - 1);
        }
        
        if (cache[n - 2] == 0) {
            cache[n - 2] = climbStairs(n - 2);
        }
        
        cache[n] = cache[n - 1] + cache[n - 2];
        return cache[n];
    }
}
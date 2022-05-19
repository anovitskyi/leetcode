class Solution {
    
    private static final int[] cache = new int[46];
    
    static {
        cache[1] = 1;
        cache[2] = 2;
    }
    
    public int climbStairs(int n) {
        if (cache[n] == 0) {
            cache[n] = climbStairs(n - 1) + climbStairs(n - 2);   
        }
        return cache[n];
    }
}
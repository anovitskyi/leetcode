class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        int[] memo = new int[n + 1];
        memo[1] = 1;
        
        int result = 0;
        for (int i = 2; i <= n; ++i) {
            memo[i] = memo[i / 2];
            if (i % 2 == 1) {
                memo[i] += memo[i / 2 + 1];
            }
            
            result = Math.max(result, memo[i]);
        }
        return result;
    }
}   

// n = 4

/**

  n = 20
  i = 10
  arr = [0, 1, 1, 2, 1, 3, 2, 3, 1, 4, 3, 5, ]

**/
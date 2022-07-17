class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        
        for (int i = 2; i < length; ++i) {
            cost[i] = cost[i] + Math.min(cost[i - 2], cost[i - 1]);
        }
        
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}
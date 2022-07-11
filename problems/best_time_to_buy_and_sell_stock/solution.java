class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int result = 0;
        
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy) {
                result = Math.max(result, prices[i] - buy);
            }
        }
        
        return result;
    }
}
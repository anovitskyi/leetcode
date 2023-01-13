class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell = prices[0];
        int result = 0;

        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            } else if (prices[i] > sell) {
                sell = prices[i];
                result = Math.max(result, sell - buy);
            }
        }

        return result;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] > min && prices[i] - min > result) {
                result = prices[i] - min;
            }
        }
        
        return result;
    }
}
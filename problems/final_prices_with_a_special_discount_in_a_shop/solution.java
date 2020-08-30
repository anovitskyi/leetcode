class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        result[prices.length - 1] = prices[prices.length - 1]; 
        
        for (int i = prices.length - 2; i >= 0; --i) {
            result[i] = prices[i];
            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[i] >= prices[j]) {
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        
        return result;
    }
}
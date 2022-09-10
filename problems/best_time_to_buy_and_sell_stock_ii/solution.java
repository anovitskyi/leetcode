class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int index = 0;
        while (index < prices.length - 1) {
            if (prices[index] < prices[index + 1]) {
                break;
            }
            ++index;
        }
        
        int result = 0;
        int start = index;
        while (index < prices.length) {
            if (prices[index] < prices[start]) {
                start = index;
            } else if (prices[index] > prices[start]) {
                int tmp = index + 1;
                while (tmp < prices.length && prices[tmp] == prices[index]) {
                    ++tmp;
                }
                
                if (tmp >= prices.length || prices[index] > prices[tmp]) {
                    result += prices[index] - prices[start];
                    start = index + 1;
                }
            }
            ++index;
        }
        return result;
    }
}

/*

    7 5 3 1 10

*/
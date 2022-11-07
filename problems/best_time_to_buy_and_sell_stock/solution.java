class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > result) {
                result = price - min;
            }
        }

        return result;
    }
}
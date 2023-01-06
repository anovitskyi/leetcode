class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int result = 0;
        for (int i = 0; i < costs.length && coins - costs[i] >= 0; ++i) {
            coins -= costs[i];
            ++result;
        }
        return result;
    }
}
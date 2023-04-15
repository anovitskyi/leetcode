class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] cache = new int[piles.size()][k + 1];
        for (int i = 0; i < cache.length; ++i) {
            for (int j = 0; j < cache[i].length; ++j) {
                cache[i][j] = -1;
            }
        }

        return calculateCoins(piles, 0, k, cache);
    }

    private int calculateCoins(List<List<Integer>> piles, int pile, int coins, int[][] cache) {
        if (pile >= piles.size()) {
            return 0;
        }

        if (cache[pile][coins] != -1) {
            return cache[pile][coins];
        }

        cache[pile][coins] = calculateCoins(piles, pile + 1, coins, cache);

        int coinsSum = 0;
        int coinsLimit = Math.min(coins, piles.get(pile).size());
        for (int coin = 0; coin < coinsLimit; ++coin) {
            coinsSum += piles.get(pile).get(coin);
            cache[pile][coins] = Math.max(cache[pile][coins], coinsSum + calculateCoins(piles, pile + 1, coins - 1 - coin, cache));
        }

        return cache[pile][coins];
    }
}
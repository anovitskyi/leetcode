class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losers = new HashMap<>();

        for (int[] result : matches) {
            losers.put(result[1], losers.getOrDefault(result[1], 0) + 1);
        }

        List<Integer> losersList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : losers.entrySet()) {
            if (entry.getValue() == 1) {
                losersList.add(entry.getKey());
            }
        }
        Collections.sort(losersList);

        List<Integer> winnersList = new ArrayList<>();
        for (int[] result : matches) {
            if (!losers.containsKey(result[0])) {
                winnersList.add(result[0]);
                losers.put(result[0], -1);
            }
        }
        Collections.sort(winnersList);

        return List.of(winnersList, losersList);
    }
}
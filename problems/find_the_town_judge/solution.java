class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> trustors = new HashMap<>(n);
        Map<Integer, List<Integer>> trustees = new HashMap<>(n);

        for (int[] pair : trust) {
            trustors.computeIfAbsent(pair[0], x -> new ArrayList<>()).add(pair[1]);
            trustees.computeIfAbsent(pair[1], x -> new ArrayList<>()).add(pair[0]);
        }

        for (int judge = 1; judge <= n; ++judge) {
            boolean doesNotTrustAnybody = !trustors.containsKey(judge);
            boolean hasEnoughTrustees = trustees.getOrDefault(judge, Collections.emptyList()).size() == n - 1;

            if (doesNotTrustAnybody && hasEnoughTrustees) {
                return judge;
            }
        }

        return -1;
    }
}
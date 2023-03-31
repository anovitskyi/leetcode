class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> trustors = new HashSet<>();
        Map<Integer, Integer> trustees = new HashMap<>();

        for (int[] pair : trust) {
            trustors.add(pair[0]);
            trustees.put(pair[1], trustees.getOrDefault(pair[1], 0) + 1);
        }

        for (int candidate = 1; candidate <= n; ++candidate) {
            if (trustors.contains(candidate)) {
                continue;
            }

            if (trustees.getOrDefault(candidate, 0) != n - 1) {
                continue;
            }

            return candidate;
        }

        return -1;
    }
}
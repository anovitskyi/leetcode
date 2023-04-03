class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], x -> new HashSet<>()).add(road[1]);
            graph.computeIfAbsent(road[1], x -> new HashSet<>()).add(road[0]);
        }

        int result = 0;

        for (int a = 0; a < n; ++a) {
            for (int b = a + 1; b < n; ++b) {
                if (!graph.containsKey(a)|| !graph.containsKey(b)) {
                    continue;
                }

                int size = graph.get(a).size() + graph.get(b).size();

                if (graph.get(a).contains(b)) {
                    --size;
                }

                if (size > result) {
                    result = size;
                }
            }
        }

        return result;
    }
}
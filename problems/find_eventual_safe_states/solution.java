class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, Integer> statuses = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < graph.length; ++i) {
            if (isSafeNode(graph, statuses, i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSafeNode(int[][] graph, Map<Integer, Integer> statuses, int node) {
        if (statuses.containsKey(node)) {
            return statuses.get(node) > 0;
        }

        if (graph[node].length == 0) {
            statuses.put(node, 2);
            return true;
        }

        statuses.put(node, 0);
        for (int nextNode : graph[node]) {
            if (!isSafeNode(graph, statuses, nextNode)) {
                return false;
            }
        }
        statuses.put(node, 1);
        return true;
    }
}
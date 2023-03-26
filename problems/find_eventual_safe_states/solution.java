class Solution {
    private static final int TERMINAL_STATUS = 1;
    private static final int VISITED_STATUS = 2;
    private static final int SAFE_STATUS = 3;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] statuses = new int[graph.length];

        for (int node = 0; node < graph.length; ++node) {
            if (allChildrenAreSafe(graph, node, statuses)) {
                result.add(node);
            }
        }

        return result;
    }

    private boolean allChildrenAreSafe(int[][] graph, int node, int[] statuses) {
        if (statuses[node] == TERMINAL_STATUS || statuses[node] == VISITED_STATUS) {
            return false;
        }
        if (statuses[node] == SAFE_STATUS) {
            return true;
        }
        
        statuses[node] = VISITED_STATUS;

        for (int next : graph[node]) {
            if (!allChildrenAreSafe(graph, next, statuses)) {
                statuses[node] = TERMINAL_STATUS;
                return false;
            }
        }

        statuses[node] = SAFE_STATUS;
        return true;
    }
}
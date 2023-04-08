class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(edges.length);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);

            if (hasCycle(graph, edge[0], -1, new HashSet<>())) {
                return edge;
            }
        }

        return new int[2];
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, int prev, Set<Integer> visited) {
        if (visited.contains(node)) {
            return true;
        }
        visited.add(node);

        for (int next : graph.get(node)) {
            if (next == prev) {
                continue;
            }

            if (hasCycle(graph, next, node, visited)) {
                return true;
            }
        }

        return false;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);

            if (hasCycle(graph, -1, edge[0], new HashSet<>())) {
                return edge;
            }
        }

        return new int[0];
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int prev, int curr, Set<Integer> visited) {
        if (visited.contains(curr)) {
            return true;
        }
        visited.add(curr);

        for (int neighbour : graph.get(curr)) {
            if (neighbour == prev) {
                continue;
            }

            if (hasCycle(graph, curr, neighbour, visited)) {
                return true;
            }
        }

        return false;
    }
}
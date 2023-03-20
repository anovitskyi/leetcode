class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        Map<Integer, List<Integer>> graph = convertToGraph(edges);

        boolean[] visited = new boolean[numCourses];
        for (int start = 0; start < numCourses; ++start) {
            if (hasCycle(graph, start, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, boolean[] visited) {
        if (visited[node]) {
            return true;
        }

        if (graph.getOrDefault(node, Collections.emptyList()).isEmpty()) {
            return false;
        }
        visited[node] = true;

        for (int neighbour : graph.get(node)) {
            if (hasCycle(graph, neighbour, visited)) {
                return true;
            }
        }

        graph.put(node, Collections.emptyList());
        visited[node] = false;
        return false;
    }

    private Map<Integer, List<Integer>> convertToGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }
        return graph;
    }
}
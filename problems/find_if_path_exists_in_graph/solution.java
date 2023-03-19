class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = convertToGraph(edges);
        return hasPath(graph, source, destination, new HashSet<>());
    }

    private boolean hasPath(Map<Integer, List<Integer>> graph, int curr, int destination, Set<Integer> visited) {
        if (curr == destination) {
            return true;
        }

        if (visited.contains(curr)) {
            return false;
        }
        visited.add(curr);

        for (int neighbour : graph.get(curr)) {
            if (hasPath(graph, neighbour, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    private Map<Integer, List<Integer>> convertToGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }
}
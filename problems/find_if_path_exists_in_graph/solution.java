class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) {
            return true;
        }
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pair : edges) {
            graph.computeIfAbsent(pair[0], x -> new HashSet<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], x -> new HashSet<>()).add(pair[0]);
        }

        return hasPath(graph, source, destination, new HashSet<>());
    }

    private boolean hasPath(Map<Integer, Set<Integer>> graph, int source, int destination, Set<Integer> visited) {
        if (!graph.containsKey(source)) {
            return false;
        }

        if (visited.contains(source)) {
            return false;
        }

        visited.add(source);

        if (source == destination) {
            return true;
        }

        for (int neighbour : graph.get(source)) {
            if (hasPath(graph, neighbour, destination, visited)) {
                return true;
            }
        }

        return false;
    }
}
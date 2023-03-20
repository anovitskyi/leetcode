import java.util.Collection;

class Solution {
    public int[] findOrder(int numCourses, int[][] edges) {
        Map<Integer, List<Integer>> graph = convertToGraph(edges);
        
        Set<Integer> path = new LinkedHashSet<>(numCourses);
        boolean[] visited = new boolean[numCourses];
        for (int start = 0; start < numCourses; ++start) {
            if (hasCycle(graph, start, path, visited)) {
                return new int[0];
            }
        }

        return convertToArray(path);
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int node, Set<Integer> path, boolean[] visited) {
        if (visited[node]) {
            return true;
        }

        if (path.contains(node)) {
            return false;
        }
        
        visited[node] = true;
        for (int neighbour : graph.getOrDefault(node, Collections.emptyList())) {
            if (hasCycle(graph, neighbour, path, visited)) {
                return true;
            }
        }
        visited[node] = false;
        path.add(node);
        
        return false;
    }

    private int[] convertToArray(Collection<Integer> collection) {
        int[] result = new int[collection.size()];
        int i = 0;
        for (int element : collection) {
            result[i++] = element;
        }
        return result;
    }

    private Map<Integer, List<Integer>> convertToGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
        }
        return graph;
    }
}
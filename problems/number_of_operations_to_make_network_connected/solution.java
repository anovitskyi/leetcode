class Solution {
    public int makeConnected(int n, int[][] edges) {
        if (edges.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        int[] components = new int[n];
        for (int i = 0; i < n; ++i) {
            components[i] = -1;
        }    

        for (int node = 0; node < n; ++node) {
            visitConnectedComponent(graph, components, node, node);
        }

        Set<Integer> connectedComponents = new HashSet<>();
        for (int component : components) {
            connectedComponents.add(component);
        }
        return connectedComponents.size() - 1;
    }

    private void visitConnectedComponent(Map<Integer, List<Integer>> graph, int[] components, int node, int group) {
        if (components[node] != -1) {
            return;
        }
        components[node] = group;

        for (int next : graph.getOrDefault(node, Collections.emptyList())) {
            visitConnectedComponent(graph, components, next, group);
        }
    }
}
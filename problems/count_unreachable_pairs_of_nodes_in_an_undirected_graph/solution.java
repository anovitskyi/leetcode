class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }

        int[] components = new int[n];
        for (int i = 0; i < n; ++i) {
            components[i] = -1;
        }

        int remainingNodes = n;
        long pairs = 0;
        for (int node = 0; node < n; ++node) {
            long sizeOfComponent = visitComponent(graph, node, node, components);
            remainingNodes -= sizeOfComponent;
            pairs += sizeOfComponent * remainingNodes;
        }
        return pairs;
    }

    private long visitComponent(Map<Integer, List<Integer>> graph, int node, int component, int[] components) {
        if (components[node] != -1) {
            return 0;
        }

        components[node] = component;
        long size = 1;
        for (int next : graph.getOrDefault(node, Collections.emptyList())) {
            size += visitComponent(graph, next, component, components);
        }
        return size;
    }
}
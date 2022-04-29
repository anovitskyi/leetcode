class Solution {
    public boolean isBipartite(int[][] graph) {
        Map<Integer, Integer> nodes = new HashMap<>();
        
        for (int i = 0; i < graph.length; ++i) {
            if (nodes.containsKey(i)) {
                continue;
            }
            
            if (!dfs(i, 1, graph, nodes)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(int node, int setNumber, int[][] graph, Map<Integer, Integer> nodes) {
        if (nodes.containsKey(node)) {
            return nodes.get(node) == setNumber;
        }
        nodes.put(node, setNumber);
        
        int[] neighbours = graph[node];
        int diffSetNumber = setNumber * - 1;
        for (int neighbour : neighbours) {
            if (!dfs(neighbour, diffSetNumber, graph, nodes)) {
                return false;
            }
        }
        
        return true;
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] sets = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (sets[i] == 0 && !dfs(graph, i, 1, sets)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[][] graph, int node, int set, int[] sets) {
        if (sets[node] != 0) {
            return sets[node] == set;
        }
        sets[node] = set;
        
        for (int i = 0; i < graph[node].length; ++i) {
            if (!dfs(graph, graph[node][i], -set, sets)) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, 0, result, curr);
        return result;
    }
    
    private void dfs(int[][] graph, int node, List<List<Integer>> result, List<Integer> curr) {
        if (node == graph.length - 1) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int neighbour : graph[node]) {
            curr.add(neighbour);
            dfs(graph, neighbour, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
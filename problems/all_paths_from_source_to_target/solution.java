class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, graph, 0, new ArrayList<>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[][] graph, int index, List<Integer> curr) {
        curr.add(index);

        if (index == graph.length - 1) {
            result.add(curr);
            return;
        }

        for (int neighbour : graph[index]) {
            dfs(result, graph, neighbour, new ArrayList<>(curr));
        }
    }
}
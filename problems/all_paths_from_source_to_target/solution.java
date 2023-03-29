class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        
        traverseGraph(graph, 0, result, new ArrayList<>());

        return result;
    }

    private void traverseGraph(int[][] graph, int node, List<List<Integer>> result, List<Integer> curr) {
        curr.add(node);

        if (node == graph.length - 1) {
            result.add(new ArrayList<>(curr));
        } else {
            for (int next : graph[node]) {
                traverseGraph(graph, next, result, curr);
            }
        }

        curr.remove(curr.size() - 1);
    }
}
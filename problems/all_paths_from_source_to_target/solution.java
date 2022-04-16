class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        curr.add(0);
        backtrack(graph, 0, result, curr);
        return result;
    }
    
    private void backtrack(int[][] graph, int index, List<List<Integer>> result, List<Integer> curr) {
        if (index == graph.length - 1) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < graph[index].length; ++i) {
            List<Integer> copy = new LinkedList<>(curr);
            copy.add(graph[index][i]);
            backtrack(graph, graph[index][i], result, copy);
        }
    }
}
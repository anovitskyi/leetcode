class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currList = new LinkedList<>();
        currList.add(0);
        backtrack(graph, 0, currList, result);
        return result;
    }
    
    private void backtrack(int[][] graph, int curr, List<Integer> currList, List<List<Integer>> result) {
        if (curr == graph.length - 1) {
            result.add(currList);
            return;
        }
        
        for (int i = 0; i < graph[curr].length; ++i) {
            List<Integer> copy = new LinkedList<>(currList);
            copy.add(graph[curr][i]);
            backtrack(graph, graph[curr][i], copy, result);
        }
    }
}
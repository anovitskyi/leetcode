class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> current = new ArrayList<>(1);
        current.add(0);
        findPaths(graph, current, result);
        return result;
    }
    
    private void findPaths(int[][] graph, List<Integer> current, List<List<Integer>> result) {
        int last = current.get(current.size() - 1);
        if (last == graph.length - 1) {
            result.add(current);
            return;
        }
        
        for (int i = 0; i < graph[last].length; ++i) {
            List<Integer> copy = new ArrayList<>(current);
            copy.add(graph[last][i]);
            findPaths(graph, copy, result);
        }
    }
}
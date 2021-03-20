class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        
        for (List<Integer> edge : edges) {
            visited[edge.get(1)] = true; 
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}

// [false, true, true, false, true, true]
//   0      1       2     3       4      5
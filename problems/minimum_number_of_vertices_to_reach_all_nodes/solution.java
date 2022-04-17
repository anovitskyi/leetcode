class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] nodes = new int[n];
        for (List<Integer> edge : edges) {
            ++nodes[edge.get(1)];
        }
        
        List<Integer> result = new LinkedList<>();
        for (int node = 0; node < n; ++node) {
            if (nodes[node] == 0) {
                result.add(node);
            }
        }
        return result;
    }
}
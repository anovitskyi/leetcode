class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), n, k, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            result.add(current);
            return;
        }
        
        for (int i = start; i <= n; ++i) {
            List<Integer> copy = new LinkedList<>(current);
            copy.add(i);
            backtrack(result, copy, n, k, i + 1);
        }
    }
}
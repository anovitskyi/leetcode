class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(k), k, 1, n);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int expectedSize, int start, int end) {
        if (curr.size() == expectedSize) {
            result.add(curr);
            return;
        }
        
        for (int i = start; i <= end; ++i) {
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(i);
            backtrack(result, copy, expectedSize, i + 1, end);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(k, n, result, new LinkedList<>(), 1);
        return result;
    }
    
    private void backtrack(int k, int n, List<List<Integer>> result, List<Integer> current, int start) {
        if (current.size() == k && n == 0) {
            result.add(current);
            return;
        }
        
        if (current.size() > k) {
            return;
        }
        
        for (int i = start; i <= 9; ++i) {
            if (i > n) {
                continue;
            }
            
            List<Integer> copy = new LinkedList<>(current);
            copy.add(i);
            backtrack(k, n - i, result, copy, i + 1);
        }
    }
}
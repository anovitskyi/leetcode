class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        backtrack(candidates, target, result, new LinkedList<>(), 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
        if (target == 0) {
            result.add(current);
            return;
        }
        
        for (int i = start; i < candidates.length; ++i) {
            if (candidates[i] > target) {
                continue;
            }
            
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            List<Integer> copy = new LinkedList<>(current);
            copy.add(candidates[i]);
            backtrack(candidates, target - candidates[i], result, copy, i + 1);
        }
    }
}
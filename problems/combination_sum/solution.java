class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), candidates, 0, target);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(curr);
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            if (target - candidates[i] >= 0) {
                List<Integer> copy = new LinkedList<>(curr);
                copy.add(candidates[i]);
                backtrack(result, copy, candidates, i, target - candidates[i]);
            }
        }
    }
}
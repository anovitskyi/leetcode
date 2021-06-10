class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(candidates, result, 0, target, new LinkedList<>());
        return result;
    }
    
    private void backtrack(int[] candidates, List<List<Integer>> result, int currIndex, int target, List<Integer> currList) {
        if (target == 0) {
            result.add(currList);
            return;
        }
            
        for (int i = currIndex; i < candidates.length; ++i) {
            if (target - candidates[i] >= 0) {
                List<Integer> copy = new LinkedList<>(currList);
                copy.add(candidates[i]);
                backtrack(candidates, result, i, target - candidates[i], copy);
            }
        }
    }
}
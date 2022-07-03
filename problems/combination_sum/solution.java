class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, result, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] candidates, int index, int target, List<List<Integer>> result, List<Integer> curr) {
        if (target == 0) {
            result.add(curr);
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            if (target - candidates[i] < 0) {
                continue;
            }
            
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], result, copy);
        }
    }
}
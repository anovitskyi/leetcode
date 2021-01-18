class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(candidates, target, new LinkedList<>(), result, 0);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, List<Integer> current, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(current);
            return;
        }
        
        for (int i = start; i < candidates.length; ++i) {
            if (target - candidates[i] < 0) {
                continue;
            }
            
            List<Integer> copy = new LinkedList<>(current);
            copy.add(candidates[i]);
            backtrack(candidates, target - candidates[i], copy, result, i);
        }
    }
}
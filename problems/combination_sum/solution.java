class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int index, int target) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        while (index < candidates.length) {
            if (target - candidates[index] >= 0) {
                curr.add(candidates[index]);
                backtrack(result, curr, candidates, index, target - candidates[index]);
                curr.remove(curr.size() - 1);
            }
            ++index;
        }
    }
    
}
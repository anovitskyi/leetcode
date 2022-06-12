class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> curr) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
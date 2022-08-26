class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] candidates, int index, int target) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            curr.add(candidates[i]);
            backtrack(result, curr, candidates, i + 1, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
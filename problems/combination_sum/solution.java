class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        findCombinations(candidates, target, result, new LinkedList<>(), 0);
        return result;
    }
    
    private void findCombinations(int[] candidates, int target, List<List<Integer>> result, List<Integer> current, int start) {
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
            findCombinations(candidates, target - candidates[i], result, copy, i);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        
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
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            if (target - candidates[i] < 0) {
                continue;
            }
            
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(candidates[i]);
            backtrack(candidates, i + 1, target - candidates[i], result, copy);
        }
    }
}

/*

[10,1,2,7,6,1,5]
[1,1,2,5,6,7,10]

*/
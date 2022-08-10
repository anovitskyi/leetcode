class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int target, int start) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = start; i < nums.length; ++i) {
            curr.add(nums[i]);
            backtrack(result, curr, nums, target - nums[i], i);
            curr.remove(curr.size() - 1);
        }
    }
}
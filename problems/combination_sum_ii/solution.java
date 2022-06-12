class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0, target);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            if (nums[i] > target) {
                continue;
            }
            
            curr.add(nums[i]);
            backtrack(result, curr, nums, i + 1, target - nums[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
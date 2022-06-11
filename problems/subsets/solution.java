class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int index) {
        if (index > nums.length) {
            return;
        }
        
        result.add(curr);
        
        for (int i = index; i < nums.length; ++i) {
            List<Integer> copy = new ArrayList<>(curr);
            curr.add(nums[i]);
            backtrack(result, copy, nums, i + 1);
        }
    }
}
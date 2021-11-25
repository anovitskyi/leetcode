class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), nums, 0);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, int start) {
        result.add(curr);
        
        for (int i = start; i < nums.length; ++i) {
            List<Integer> copy = new LinkedList<>(curr);
            copy.add(nums[i]);
            backtrack(result, copy, nums, i + 1);
        }
    }
}
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, 0, result, new LinkedList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> curr) {
        result.add(curr);
        
        for (int i = index; i < nums.length; ++i) {
            List<Integer> copy = new LinkedList<>(curr);
            copy.add(nums[i]);
            backtrack(nums, i + 1, result, copy);
        }
    }
}
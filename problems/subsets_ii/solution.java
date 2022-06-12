class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result, new ArrayList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int index, List<List<Integer>> result, List<Integer> curr) {
        if (index > nums.length) {
            return;
        }
        
        result.add(curr);
        
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(nums[i]);
            backtrack(nums, i + 1, result, copy);
        }
    }
}
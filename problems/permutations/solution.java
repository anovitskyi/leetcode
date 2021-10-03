class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), nums);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (current.contains(nums[i])) {
                continue;
            }
            
            List<Integer> copy = new LinkedList<>(current);
            copy.add(nums[i]);
            backtrack(result, copy, nums);
        }
    }
}
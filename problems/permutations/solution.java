class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        
        backtrack(result, new LinkedList<>(), nums);
        
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= Integer.MIN_VALUE) {
                continue;
            }
            int tmp = nums[i];
            nums[i] = Integer.MIN_VALUE;
            List<Integer> copy = new LinkedList<>(curr);
            copy.add(tmp);
            backtrack(result, copy, nums);
            nums[i] = tmp;
        }
    }
}
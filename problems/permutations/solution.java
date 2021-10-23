class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        backtrack(result, new LinkedList<>(), nums, new boolean[21]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] cache) {
        if (curr.size() == nums.length) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (cache[nums[i] + 10] == false) {
                cache[nums[i] + 10] = true;
                List<Integer> copy = new LinkedList<>(curr);
                copy.add(nums[i]);
                backtrack(result, copy, nums, cache);
                cache[nums[i] + 10] = false;
            } 
        }
    }
}
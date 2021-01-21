class Solution {                                     // . . .
    public List<List<Integer>> subsets(int[] nums) { // 1 2 3
        List<List<Integer>> result = new LinkedList<>();
        backtrack(nums, 0, result, new LinkedList<>());
        return result;
    }
    
    private void backtrack(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        result.add(current);
        for (int i = start; i < nums.length; ++i) {
            List<Integer> copy = new LinkedList<>(current);
            copy.add(nums[i]);
            backtrack(nums, i + 1, result, copy);
        }
    }
}

// <>, <1>, <1, 2>, <1, 2 ,3>
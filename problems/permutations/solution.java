class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(curr);
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            List<Integer> copy = new ArrayList<>(curr);
            copy.add(nums[i]);
            backtrack(result, copy, nums, visited);
            visited[i] = false;
        }
    }
}
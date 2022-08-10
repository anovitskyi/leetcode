class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int[] nums, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (visited[i]) {
                continue;
            }
            
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(result, curr, nums, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
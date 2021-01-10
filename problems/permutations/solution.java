class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(nums, new ArrayList<>(0), result, new boolean[nums.length]);
        return result;
    }
    
    private void permute(int[] nums, List<Integer> current, List<List<Integer>> result, boolean[] visited) {
        if (current.size() == nums.length) {
            result.add(current);
            return;
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                List<Integer> copy = new ArrayList<>(current);
                copy.add(nums[i]);
                permute(nums, copy, result, visited);
                visited[i] = false;
            }
        }
    }
}
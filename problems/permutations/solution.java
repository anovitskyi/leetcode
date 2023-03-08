class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        backtrack(nums, visited, result, curr);
        
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> curr) {
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
            backtrack(nums, visited, result, curr);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
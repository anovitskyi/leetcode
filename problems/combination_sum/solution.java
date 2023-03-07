class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates, 0, result, curr, target);

        return result;
    }

    private void backtrack(int[] candidates, int index, List<List<Integer>> result, List<Integer> curr, int target) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            curr.add(candidates[i]);
            backtrack(candidates, i, result, curr, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }
}
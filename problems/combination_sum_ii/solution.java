class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(candidates, target, 0, result, curr);

        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> curr) {
        if (target <= 0) {
            if (target == 0) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, result, curr);
            curr.remove(curr.size() - 1);
        }
    }
}

/*
    [10,1,2,7,6,1,5]
    [1,1,2,5,6,7,10]
 */
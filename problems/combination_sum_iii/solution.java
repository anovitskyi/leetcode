class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, 0, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> curr, int targetSize, int sum, int targetSum, int startNumber) {
        if (curr.size() == targetSize) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int number = startNumber; number <= 9; ++number) {
            curr.add(number);
            backtrack(result, curr, targetSize, sum + number, targetSum, number + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
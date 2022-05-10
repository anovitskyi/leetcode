class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }
    
    private void backtrack(List<List<Integer>> result, List<Integer> curr, int size, int target, int startingIndex) {
        if (target == 0) {
            if (curr.size() == size) {
                result.add(curr);
            }
            
            return;
        }
        
        for (int index = startingIndex; index < 10; ++index) {
            int newSum = target - index;
            
            if (newSum < 0) {
                continue;
            }
            
            List<Integer> currCopy = new ArrayList<>(curr);
            currCopy.add(index);
            backtrack(result, currCopy, size, newSum, index + 1);
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(result, n, n, "");
        return result;
    }
    
    private void backtrack(List<String> result, int left, int right, String current) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        
        backtrack(result, left - 1, right, current + "(");
        backtrack(result, left, right - 1, current + ")");
    }
}
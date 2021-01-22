class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(n, n, result, "");
        return result;
    }
    
    private void backtrack(int left, int right, List<String> result, String current) {
        if (left == 0 && right == 0) {
            result.add(current);
            return;
        }
        
        if (left > right) {
            return;
        }
        
        if (left - 1 >= 0) {
            backtrack(left - 1, right, result, current + "(");   
        }
        
        if (right - 1 >= 0) {
            backtrack(left, right - 1, result, current + ")");   
        }
    }
}
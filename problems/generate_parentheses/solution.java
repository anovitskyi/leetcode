class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        String curr = "";
        
        backtrack(result, curr, n, n);
        
        return result;
    }
    
    private void backtrack(List<String> result, String curr, int open, int close) {
        if (open == 0 && close == 0) {
            result.add(curr);
            return;
        }
        
        if (open > 0) {
          backtrack(result, curr + "(", open - 1, close);    
        }
        
        if (close > open) {
          backtrack(result, curr + ")", open, close - 1);  
        }
    }
}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generate(result, "", n, n);
        return result;
    }
    
    private void generate(List<String> result, String curr, int open, int close) {
        if (open > close) {
            return;
        }
        
        if (open == 0 && close == 0) {
            result.add(curr);
            return;
        }
        
        if (open > 0) {
            generate(result, curr + "(", open - 1, close);
        }
        
        if (close > 0) {
            generate(result, curr + ")", open, close - 1);
        }
    }
}
// result = ["()"]

// "()",
// "", 1, 1 - close
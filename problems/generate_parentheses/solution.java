class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", n, n);
        return result;
    }
    
    private void backtrack(List<String> result, String curr, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(curr);
            return;
        }
        
        if (left > 0) {
            backtrack(result, curr + "(", left - 1, right);
        } 
        
        if (right > left) {
            backtrack(result, curr + ")", left, right - 1);
        }
    }
}

/*
    result = ["(())", "()()"]

*/
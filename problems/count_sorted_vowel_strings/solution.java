class Solution {
    public int countVowelStrings(int n) {
        int[] result = new int[1];
        backtrack(n, 0, result);
        return result[0];
    }
    
    private void backtrack(int n, int index, int[] result) {
        if (n == 0) {
            ++result[0];
            return;
        }
        
        for (int i = index; i < 5; ++i) {
            backtrack(n - 1, i, result);
        }
    } 
}
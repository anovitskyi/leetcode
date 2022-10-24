class Solution {
    public int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }
    
    private int backtrack(List<String> array, int index, String curr) {
        if (hasDuplicates(curr)) {
            return 0;
        }
        
        if (index >= array.size()) {
            return curr.length();
        }
        
        int result = curr.length();
        
        for (int i = index; i < array.size(); ++i) {
            result = Math.max(result, backtrack(array, i + 1, curr + array.get(i)));
        }
        
        return result;
    }
    
    private boolean hasDuplicates(String word) {
        boolean[] tmp = new boolean[26];
        
        for (int i = 0; i < word.length(); ++i) {
            int charIndex = word.charAt(i) - 'a';
            if (tmp[charIndex]) {
                return true;
            }
            
            tmp[charIndex] = true;
        }
        
        return false;
    }
}
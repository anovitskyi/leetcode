class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        
        for (int i = 0; i < s.length(); ++i) {
            String curr =  findPalindromeLength(s, i);
            if (curr.length() > result.length()) {
                result = curr;
            }    
        }
        
        return result;
    }
    
    private String findPalindromeLength(String word, int start) {
        String odd = findPalindrome(word, start - 1, start + 1);
        String even = findPalindrome(word, start, start + 1);
        
        if (odd.length() > even.length()) {
            return odd;
        }
        
        return even;
    }
    
    private String findPalindrome(String word, int left, int right) {
        while (left >= 0 && right < word.length() && word.charAt(left) == word.charAt(right)) {
            --left;
            ++right;
        }
        
        if (left < 0 && right >= word.length()) {
            return word;
        }
        
        // if (left < 0 || right >= word.length()) {
        //     return "";
        // }
        
        return word.substring(left + 1, right);
    }
}

/*

    babad
    dabab

*/
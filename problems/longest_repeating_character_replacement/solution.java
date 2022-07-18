class Solution {
    public int characterReplacement(String s, int k) {
        int[] chars = new int[26];
        int left = 0;
        int right = 0;
        int result = 0;
        
        while (right < s.length()) {   
            ++chars[s.charAt(right) - 'A'];
            ++right;
            
            int max = 0;
            for (int i = 0; i < chars.length; ++i) {
                if (chars[i] > max) {
                    max = chars[i];
                }
            }
            
            if (max + k < right - left) {
                --chars[s.charAt(left) - 'A'];
                ++left;
            }
            
            result = Math.max(result, right - left);
        }
        
        return result;
    }
}


/* 
a: 2
b: 3

k = 1

left     |
      "AABABBA"
right         |


*/
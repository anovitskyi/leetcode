class Solution {
    public int countBinarySubstrings(String s) {
        int result = 0;
        
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                char initLeft = s.charAt(i - 1);
                char initRight = s.charAt(i);
                int left = i - 1;
                
                while (s.charAt(left) == initLeft && s.charAt(i) == initRight) {
                    ++result;
                    --left;
                    ++i;
                    
                    if (left < 0 || i >= s.length()) {
                        break;
                    }
                }
                
                --i;
            }
        }
        
        return result;
    }
}
class Solution {
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
    
        int max = 1;
    
        for (int i = 1; i < s.length(); ++i) {
            int start = i - 1;
            while (i < s.length() && s.charAt(start) == s.charAt(i)) {
                ++i;
            }
            
            max = Math.max(max, i - start);
        }
        
        return max;
    }
}
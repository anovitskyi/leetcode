class Solution {
    public int maxPower(String s) { // "abbcccddddeeeeedcba", length = 19
        int max = Integer.MIN_VALUE; // -1
        
        for (int i = 0; i < s.length(); ) { // 0 < 19;
            int length = i + 1; // 1
            while (length < s.length() && s.charAt(i) == s.charAt(length)) {
                ++length;
            }
            
            max = Math.max(max, length - i);
            i = length;
        }
        
        return max;
    }
}
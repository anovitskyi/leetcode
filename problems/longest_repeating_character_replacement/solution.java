class Solution {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int[] counters = new int[26];
        int maxCounter = 0;
        int result = 0;
        
        while (end < s.length()) {
            int letterIndex = s.charAt(end) - 'A';
            ++counters[letterIndex];
            int currentWindowLength = end - start + 1;
            maxCounter = Math.max(maxCounter, counters[letterIndex]);
            int numberOfDifferentLetters = currentWindowLength - maxCounter;
            
            if (numberOfDifferentLetters > k) {
                --counters[s.charAt(start) - 'A'];
                ++start;
            } else {
                result = Math.max(result, currentWindowLength);   
            }
            
            ++end;
        }
        
        return result;
    }
}
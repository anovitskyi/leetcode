class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] counters = new int[2];
        int result = 0;
        int left = 0;
        int right = 0;
        
        while (right < answerKey.length()) {
            if (Math.min(counters[0], counters[1]) <= k) {
                ++counters[convertLetterToIndex(answerKey.charAt(right++))];
                if (Math.min(counters[0], counters[1]) <= k) {
                    result = Math.max(result, right - left);
                }
            } else {
                --counters[convertLetterToIndex(answerKey.charAt(left++))];
            }
        }
        
        return result;
    }
    
    private int convertLetterToIndex(char ch) {
        if (ch == 'F') {
            return 0;
        }
        
        return 1;
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int result = 0;
        
        int left = 0;
        int right = tokens.length - 1;
        while (left <= right) {
            if (power >= tokens[left]) {
                power -= tokens[left];
                ++left;
                ++score;
                
                result = Math.max(score, result);
            } else if (score >= 1) {
                power += tokens[right];
                --right;
                --score;
            } else {
                break;
            }
        }
        
        return result;
    }
}
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[][] letters = new int[26][2];
        for (int i = 0; i < 26; ++i) {
            letters[i][0] = -1;
            letters[i][1] = -1;
        }
        
        for (int i = 0; i < s.length(); ++i) {
            int num = s.charAt(i) - 'a';
            
            if (letters[num][0] == -1) {
                letters[num][0] = i;
            } else {
                letters[num][1] = i;
            }
        }
        
        int max = -1;
        for (int i = 0; i < 26; ++i) {
            if (letters[i][0] == -1 || letters[i][1] == -1) {
                continue;
            }
            
            max = Math.max(max, letters[i][1] - letters[i][0] - 1);
        }
        return max;
    }
}
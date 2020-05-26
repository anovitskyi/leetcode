class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        
        int[] tab = new int[26];
        for (char ch : chars.toCharArray()) {
            ++tab[(int) (ch - 'a')];
        }
        
        for (String word : words) {
            int[] wordTab = new int[26];
            System.arraycopy(tab, 0, wordTab, 0, 26);
            
            result += word.length();
            for (char ch : word.toCharArray()) {
                if (--wordTab[ch - 'a'] < 0) {
                    result -= word.length();
                    break;
                }
            }
        }
        
        return result;
    }
}
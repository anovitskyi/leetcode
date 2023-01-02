class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;
        for (int i = 0; i < word.length(); ++i) {
            if (word.charAt(i) <= 'Z') {
                ++capitals;
            }
        }

        return capitals == word.length() || capitals == 0 || (capitals == 1 && word.charAt(0) <= 'Z');
    }
}
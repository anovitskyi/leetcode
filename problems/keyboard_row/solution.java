class Solution {
    public String[] findWords(String[] words) {
        int[] letters = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
        
        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (isOnSameLine(word, letters)) {
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    
    private boolean isOnSameLine(String word, int[] letters) {
        int prev = letters[Character.toLowerCase(word.charAt(0)) - 'a'];
        for (int i = 1; i < word.length(); ++i) {
            int cur = letters[Character.toLowerCase(word.charAt(i)) - 'a'];
            
            if (prev != cur) {
                return false;
            }
            
            prev = cur;
        }
        return true;
    }
}
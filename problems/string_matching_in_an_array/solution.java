class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new LinkedList<>();
        
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words.length; ++j) {
                if (i == j || words[i].length() > words[j].length()) {
                    continue;
                }
                
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        
        return result;
    }
}
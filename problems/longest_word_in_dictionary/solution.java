class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String result = "";
        Trie root = new Trie();
        for (String word : words) {
            if (root.insert(word) && (word.length() > result.length() || (result.length() == word.length() && word.compareTo(result) < 0))) {
                result = word;
            }
        }
        return result;
    }
    
    private class Trie {
        boolean isEndOfWord = false;
        Map<Character, Trie> children = new HashMap<>();
        
        boolean insert(String word) {
            Trie tmp = this;
            
            for (int i = 0; i < word.length(); ++i) {
                Trie nextTmp = tmp.children.get(word.charAt(i));
                if (nextTmp == null) {
                    if (i < word.length() - 1) {
                        return false;   
                    }
                    nextTmp = new Trie();
                    tmp.children.put(word.charAt(i), nextTmp);
                }
                
                tmp = nextTmp;
            }
            
            tmp.isEndOfWord = true;
            return true;
        }
    }
}
class Trie {

    private final TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode last = root;
        
        for (int i = 0; i < word.length(); ++i) {
            last = last.nodes.computeIfAbsent(word.charAt(i), x -> new TrieNode());
        }
        
        last.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode last = getLastNode(word);
        return last != null && last.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return getLastNode(prefix) != null;
    }
    
    private TrieNode getLastNode(String word) {
        TrieNode last = root;
        
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            
            if (!last.nodes.containsKey(ch)) {
                return null;
            }
            
            last = last.nodes.get(ch);
        }
        
        return last;
    }
    
    private class TrieNode {
        boolean isEndOfWord = false;
        final Map<Character, TrieNode> nodes = new HashMap<>();
    }
}
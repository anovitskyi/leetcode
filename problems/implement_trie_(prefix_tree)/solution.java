class Trie {
    
    private final TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode tmp = root;
        for (char letter : word.toCharArray()) {
            tmp = tmp.children.computeIfAbsent(letter, l -> new TrieNode());
        }
        tmp.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode lastTrieNode = getLastTrieNode(word);
        return lastTrieNode != null && lastTrieNode.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return getLastTrieNode(prefix) != null;
    }
    
    private TrieNode getLastTrieNode(String word) {
        TrieNode tmp = root;
        for (char letter : word.toCharArray()) {
            if (!tmp.children.containsKey(letter)) {
                return null;
            }
            
            tmp = tmp.children.get(letter);
        }
        return tmp;
    }
    
    private class TrieNode {
        boolean isEndOfWord = false;
        Map<Character, TrieNode> children = new HashMap<>();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
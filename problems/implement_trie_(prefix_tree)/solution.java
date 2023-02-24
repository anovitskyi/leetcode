class Trie {

    private final TrieNode root = new TrieNode();
    
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            TrieNode nextNode = null;
            if (node.children[index] == null) {
                nextNode = new TrieNode();
                node.children[index] = nextNode;
            } else {
                nextNode = node.children[index];
            }

            node = nextNode;
        }

        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';

            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        
        return node.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); ++i) {
            int index = prefix.charAt(i) - 'a';

            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    private class TrieNode {
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
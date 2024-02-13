class Trie {

    private final Node root = new Node();
    
    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            node = node.children.computeIfAbsent(ch, x -> new Node());
        }

        node.isEndOfWord = true;
    }

    private Node getLastNodeFor(String word) {
        Node node = root;

        for (int i = 0; i < word.length() && node != null; ++i) {
            char ch = word.charAt(i);
            node = node.children.get(ch);
        }

        return node;
    }
    
    public boolean search(String word) {
        Node lastNode = getLastNodeFor(word);
        return lastNode != null && lastNode.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return getLastNodeFor(prefix) != null;
    }

    private static class Node {

        final Map<Character, Node> children = new HashMap<>();
        boolean isEndOfWord = false;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
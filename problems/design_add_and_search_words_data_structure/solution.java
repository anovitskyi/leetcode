class WordDictionary {

    private final TrieNode root = new TrieNode();
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); ++i) {
            int index = word.charAt(i) - 'a';
            TrieNode next = null;

            if (node.children[index] == null) {
                next = new TrieNode();
                node.children[index] = next;
            } else {
                next = node.children[index];
            }

            node = next;
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Queue<SearchNode> queue = new LinkedList<>();
        queue.add(new SearchNode(root, 0));

        while (!queue.isEmpty()) {
            SearchNode searchNode = queue.poll();
            TrieNode node = searchNode.node;
            int index = searchNode.index;

            if (index >= word.length()) {
                if (node.isEndOfWord) {
                    return true;
                } else {
                    continue;
                }
            }

            if (word.charAt(index) == '.') {
                for (int i = 0; i < node.children.length; ++i) {
                    if (node.children[i] != null) {
                        queue.offer(new SearchNode(node.children[i], index + 1));
                    }
                }
            } else {
                int charIndex = word.charAt(index) - 'a';
                if (node.children[charIndex] != null) {
                    queue.offer(new SearchNode(node.children[charIndex], index + 1));
                }
            }
        }

        return false;
    }

    private class TrieNode {
        boolean isEndOfWord = false;
        final TrieNode[] children = new TrieNode[26];
    }

    private class SearchNode {
        final TrieNode node;
        final int index;

        SearchNode(TrieNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
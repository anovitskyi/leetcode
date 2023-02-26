class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = convertWordsToTrie(words);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                checkWord(board, i, j, root, set);
            }
        }

        List<String> result = new ArrayList<>(set.size());
        for (String str : set) {
            result.add(str);
        }
        return result;
    }

    private void checkWord(char[][] board, int i, int j, TrieNode node, Set<String> set) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '\0') {
            return;
        }

        char ch = board[i][j];
        if (!node.children.containsKey(ch)) {
            return;
        }

        node = node.children.get(ch);
        if (node.isEndOfWord) {
            set.add(node.word);
        }

        board[i][j] = '\0';
        checkWord(board, i - 1, j, node, set);
        checkWord(board, i + 1, j, node, set);
        checkWord(board, i, j - 1, node, set);
        checkWord(board, i, j + 1, node, set);
        board[i][j] = ch;
    }

    private TrieNode convertWordsToTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWordToTrie(word, root);
        }
        return root;
    }

    private void addWordToTrie(String word, TrieNode node) {
        if (word == null || word.isEmpty()) {
            return;
        }

        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            node = node.children.computeIfAbsent(ch, x -> new TrieNode());
        }

        node.isEndOfWord = true;
        node.word = word;
    }

    private static class TrieNode {
        private final Map<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord = false;
        private String word = null;
    }
}
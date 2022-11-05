class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie curr = root;

            for (int i = 0; i < word.length(); ++i) {
                curr = curr.children.computeIfAbsent(word.charAt(i), x -> new Trie());
            }

            curr.word = word;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                findWord(board, i, j, root, set);
            }
        }

        List<String> result = new ArrayList<>();
        for (String word : set) {
            result.add(word);
        }
        return result;
    }

    private void findWord(char[][] board, int i, int j, Trie trie, Set<String> set) {
        if (i < 0 || i >= board.length) {
            return;
        }

        if (j < 0 || j >= board[i].length) {
            return;
        }

        if (!trie.children.containsKey(board[i][j])) {
            return;
        }

        Trie next = trie.children.get(board[i][j]);

        if (next.word != null) {
            set.add(next.word);
        }

        char tmp = board[i][j];
        board[i][j] = '0';
        findWord(board, i - 1, j, next, set);
        findWord(board, i + 1, j, next, set);
        findWord(board, i, j - 1, next, set);
        findWord(board, i, j + 1, next, set);
        board[i][j] = tmp;
    }

    private class Trie {
        final Map<Character, Trie> children = new HashMap<>();
        String word = null;
    }
}
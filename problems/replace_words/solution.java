class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = prepareTrie(dictionary);
        StringBuilder builder = new StringBuilder();
        String separator = "";
        for (String word : sentence.split(" ")) {
            builder.append(separator).append(replaceWord(word, root));
            separator = " ";
        }
        return builder.toString();
    }
    
    private class Trie {
        boolean isEndOfWord = false;
        Map<Character, Trie> children = new HashMap<>();
    }
    
    private Trie prepareTrie(List<String> words) {
        Trie root = new Trie();
        for (String word : words) {
            addWordToTrie(word, root);
        }
        return root;
    }
    
    private void addWordToTrie(String word, Trie root) {
        for (char ch : word.toCharArray()) {
            Trie newRoot = root.children.computeIfAbsent(ch, x -> new Trie());
            root = newRoot;
        }
        root.isEndOfWord = true;
    }
    
    private String replaceWord(String word, Trie root) {
        StringBuilder builder = new StringBuilder();
        for (char ch : word.toCharArray()) {
            Trie newRoot = root.children.get(ch);
            
            if (newRoot == null) {
                return word;
            } 
            
            builder.append(ch);
            
            if (newRoot.isEndOfWord) {
                return builder.toString();
            }
            
            root = newRoot;
        }
        return word;
    }
}
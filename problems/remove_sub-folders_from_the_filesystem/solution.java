class Solution {
    public List<String> removeSubfolders(String[] folders) {
        Arrays.sort(folders, (a, b) -> a.length() - b.length());
        List<String> result = new LinkedList<>();
        Trie root = new Trie();
        for (String folder : folders) {
            if (root.add(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
    
    private class Trie {
        boolean isEndOfWord;
        Map<String, Trie> children = new HashMap<>();
        
        boolean add(String folder) {
            Trie root = this;
            String[] splittedFolders = folder.split("/");
            for (int i = 1; i < splittedFolders.length; ++i) {
                Trie nextTrie = root.children.computeIfAbsent(splittedFolders[i], name -> new Trie());
                if (nextTrie.isEndOfWord) {
                    return false;
                }
                root = nextTrie;
            }
            root.isEndOfWord = true;
            return true;
        }
    }
}
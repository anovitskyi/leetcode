class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = convertDictToTrie(wordDict);
        return canBreakWord(s, 0, root, new HashSet<>());
    }
                                                                                
    private boolean canBreakWord(String word, int index, Trie root, Set<Integer> visitedIndexes) {
        if (visitedIndexes.contains(index)) {
            return false;
        }
        
        if (index >= word.length()) {
            return true;
        }
        
        Trie currRoot = root;
        int startIndex = index;
        
        while (index < word.length()) {
            currRoot = currRoot.children.get(word.charAt(index));
            if (currRoot == null) {
                visitedIndexes.add(startIndex);
                return false;
            }
            ++index;
            if (currRoot.isEndOfWord && canBreakWord(word, index, root, visitedIndexes)) {
                return true;
            }
        }
        
        return currRoot.isEndOfWord;
        
    }
    
    private static class Trie {
        Map<Character, Trie> children = new HashMap<>();
        boolean isEndOfWord = false;
    }
    
    private Trie convertDictToTrie(List<String> dict) {
        Trie root = new Trie();
        for (String word : dict) {
            addWordToTrie(word, root);
        }
        return root;
    }
    
    private void addWordToTrie(String word, Trie trie) {
        for (char ch : word.toCharArray()) {
            trie = trie.children.computeIfAbsent(ch, letter -> new Trie());
        }
        trie.isEndOfWord = true;
    }
}



// class Solution {
    
//     private class Trie {
//         Map<Character, Trie> children = new HashMap<>();
//         boolean isEndOfWord = false;
//     }
    
//     private Trie convertDictToTrie(List<String> dict) {
//         Trie root = new Trie();
//         for (String word : dict) {
//             addWordToTrie(word, root);
//         }
//         return root;
//     }
    
//     private void addWordToTrie(String word, Trie trie) {
//         for (char ch : word.toCharArray()) {
//             trie = trie.children.computeIfAbsent(ch, letter -> new Trie());
//         }
//         trie.isEndOfWord = true;
//     }

    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Trie root = convertDictToTrie(wordDict);
//         return canBreakWord(s, root, 0, new HashSet<>());
        
//     }
    
//     public boolean canBreakWord(String word, Trie root, int index, Set<Integer> bad) {
//         if (bad.contains(index)) {
//             return false;
//         }
        
//         if (index >= word.length()) {
//             return true;
//         }
    
//         int startIndex = index;
//         Trie currRoot = root;
        
//         while (index < word.length()) {
//             currRoot = currRoot.children.get(word.charAt(index));
//             if (currRoot == null) {
//                 bad.add(startIndex);
//                 return false;   
//             }
            
//             index++; 
//             if (currRoot.isEndOfWord && canBreakWord(word, root, index, bad)) {
//                 return true;
//             }
//         }
        
//         return currRoot.isEndOfWord;
//     }
// }
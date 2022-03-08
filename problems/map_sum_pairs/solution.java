class MapSum {
    
    private final Map<String, Integer> cache = new HashMap<>();
    private final Trie root = new Trie();
    
    public void insert(String key, int val) {
        Integer prevKey = cache.get(key);
        cache.put(key, val);
        if (prevKey != null) {
            val -= prevKey;
        }
        
        Trie tmp = root;
        for (char ch : key.toCharArray()) {
            Trie nextTmp = tmp.children.computeIfAbsent(ch, letter -> new Trie());
            nextTmp.sum += val;
            tmp = nextTmp;
        }
    }
    
    public int sum(String prefix) {
        Trie tmp = root;
        for (char ch : prefix.toCharArray()) {
            Trie nextTmp = tmp.children.get(ch);
            if (nextTmp == null) {
                return 0;
            }
            tmp = nextTmp;
        }
        return tmp.sum;
    }
    
    private class Trie {
        int sum = 0;
        Map<Character, Trie> children = new HashMap<>();
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
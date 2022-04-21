class MyHashSet {
    
    private final boolean[] elements = new boolean[1_000_001];
    
    public void add(int key) {
        elements[key] = true;
    }
    
    public void remove(int key) {
        elements[key] = false;
    }
    
    public boolean contains(int key) {
        return elements[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
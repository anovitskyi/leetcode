class MyHashSet {
    
    private boolean[] array = new boolean[1_000_001];

    /** Initialize your data structure here. */
    public MyHashSet() {
        
    }
    
    public void add(int key) {
        array[key] = true;
    }
    
    public void remove(int key) {
        array[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return array[key];
    }
}
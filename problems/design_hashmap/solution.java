class MyHashMap {
    
    private final Integer[] buckets;

    public MyHashMap() {
        buckets = new Integer[1000001];
    }
    
    public void put(int key, int value) {
        buckets[key] = value;
    }
    
    public int get(int key) {
        return buckets[key] == null ? -1: buckets[key];
    }
    
    public void remove(int key) {
        buckets[key] = null;
    }
    
}
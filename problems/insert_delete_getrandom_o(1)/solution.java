class RandomizedSet {

    private final List<Integer> items = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();
    private int last = 0;
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        items.add(val);
        swap(last, items.size() - 1);
        map.put(val, last);
        ++last;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int indexToRemove = map.get(val);
        map.put(items.get(last - 1), indexToRemove);
        map.remove(val);
        --last;
        swap(indexToRemove, last);
        return true;
    }
    
    public int getRandom() {
        int randIndex = new Random().nextInt(last);
        return items.get(randIndex);
    }
    
    private void swap(int f, int s) {
        int copy = items.get(f);
        items.set(f, items.get(s));
        items.set(s, copy);
    }
    
}
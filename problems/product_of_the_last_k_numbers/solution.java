class ProductOfNumbers {
    
    private final Map<Integer, Integer> map = new HashMap<>();
    private int lastIndexOfZero = -1;
    
    public void add(int num) {
        if (num == 0) {
            lastIndexOfZero = map.size();
            map.put(map.size(), 1);
        } else {
            map.put(map.size(), map.getOrDefault(map.size() - 1, 1) * Math.max(1, num));
        }
    }
    
    public int getProduct(int k) {
        if (map.size() - k - 1 < lastIndexOfZero) {
            return 0;
        }
        
        return map.get(map.size() - 1) / map.getOrDefault(map.size() - k - 1, 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
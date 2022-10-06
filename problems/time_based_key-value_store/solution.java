class TimeMap {
    
    private final Map<String, List<Value>> map = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Value(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Value> list = map.getOrDefault(key, Collections.emptyList());
        
        if (list.isEmpty() || list.get(0).timestamp > timestamp) {
            return "";
        }
        
        int left = 0;
        int right = list.size() - 1;
        int result = left;
        
        while (left <= right) {
            int middle = left + (right - left) / 2;
            
            if (list.get(middle).timestamp <= timestamp) {
                result = middle;
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return list.get(result).value;
    }
    
    private class Value {
        private final int timestamp;
        private final String value;
        
        Value(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
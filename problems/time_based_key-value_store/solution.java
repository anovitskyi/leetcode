class TimeMap {

    private final Map<String, List<Pair>> store = new HashMap<>();
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, x -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = store.get(key);
        if (values == null) {
            return "";
        }

        int left = 0;
        int right = values.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            Pair midPair = values.get(mid);

            if (midPair.timestamp <= timestamp) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (result == -1) {
            return "";
        }
        return values.get(result).value;
    }

    class Pair {
        final int timestamp;
        final String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }
}
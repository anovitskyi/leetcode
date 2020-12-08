class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>(time.length);
        int counter = 0;
        
        for (int i = time.length - 1; i >= 0; --i) {
            int mod = time[i] % 60;
            int search = mod == 0 ? 0 : 60 - mod;
            counter += map.getOrDefault(search, 0);
            
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        
        return counter;
    }
}
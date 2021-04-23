class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCounter = 0;
        
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                sum += list.get(i);
                int counter = map.getOrDefault(sum, 0) + 1;
                map.put(sum, counter);
                maxCounter = Math.max(counter, maxCounter);
            }
        }
        
        return wall.size() - maxCounter;
    }
}
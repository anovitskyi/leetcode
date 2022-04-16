class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < edges.length; ++i) {
            for (int j = 0; j < edges[i].length; ++j) {
                int counter = map.getOrDefault(edges[i][j], 0) + 1;
                map.put(edges[i][j], counter);
            }
        }
        
        int result = 1;
        for (int key : map.keySet()) {
            if (map.get(key) > map.get(result)) {
                result = key;
            }
        }
        return result;
    }
}
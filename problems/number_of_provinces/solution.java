class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> graph = convertToGraph(isConnected);
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        
        for (int i = 0; i < isConnected.length; ++i) {
            if (visited.contains(i)) {
                continue;
            }
            
            visitCity(graph, i, visited);
            ++result;
        }
        
        return result;
    }
    
    private void visitCity(Map<Integer, List<Integer>> graph, int city, Set<Integer> visited) {
        if (visited.contains(city)) {
            return;
        }
        
        visited.add(city);
        
        for (int neighbour : graph.get(city)) {
            visitCity(graph, neighbour, visited);
        }
    }
    
    private Map<Integer, List<Integer>> convertToGraph(int[][] isConnected) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < isConnected.length; ++i) {
            List<Integer> neighbours = new ArrayList<>();
            map.put(i, neighbours);
            
            for (int j = 0; j < isConnected[i].length; ++j) {
                if (i == j) {
                    continue;
                }
                
                if (isConnected[i][j] == 0) {
                    continue;
                }
                
                neighbours.add(j);
            }
        }
        
        return map;
    }
}
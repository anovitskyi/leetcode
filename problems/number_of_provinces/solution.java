class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; ++i) {
            int[] cities = isConnected[i];
            Set<Integer> set = new HashSet<>();
            graph.put(i, set);
            
            for (int j = 0; j < cities.length; ++j) {
                if (cities[j] == 1 && j != i) {
                    set.add(j);
                }
            }
        }
        
        boolean[] visited = new boolean[graph.size()];
        int result = 0;
        
        for (int city = 0; city < graph.size(); ++city) {
            if (visited[city]) {
                continue;
            }
            
            visitCities(city, graph, visited);
            
            ++result; 
        }
         
        return result;
    }
    
    private void visitCities(int city, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        if (visited[city]) {
            return;
        }
        
        visited[city] = true;
        
        for (int neighbour : graph.get(city)) {
            visitCities(neighbour, graph, visited);
        }
    }
}
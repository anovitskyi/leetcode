class Solution {
    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        
        for (int i = 0; i < isConnected.length; ++i) {
            if (visited.contains(i)) {
                continue;
            }
            
            dfs(i, isConnected, visited);
            ++result;
        }
        
        return result;
    }
    
    private void dfs(int start, int[][] isConnected, Set<Integer> visited) {
        int[] neighbors = isConnected[start];
        
        for (int i = 0; i < neighbors.length; ++i) {
            if (i == start) {
                continue;
            }
            
            if (neighbors[i] == 0) {
                continue;
            }
            
            if (visited.contains(i)) {
                continue;
            }
            
            visited.add(i);
            dfs(i, isConnected, visited);
        }
    }
}
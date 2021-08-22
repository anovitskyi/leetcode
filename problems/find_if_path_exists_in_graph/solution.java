class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if (start == end) {
            return true;
        }
        
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], $ -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], $ -> new HashSet<>()).add(edge[0]);
        }
        
        return dfs(visited, map, start, end);
    }
    
    private boolean dfs(boolean[] visited, Map<Integer, Set<Integer>> map, int start, int end) {
        visited[start] = true;
        if (map.get(start) == null) {
            return false;
        }
        
        if (map.get(start).contains(end)) {
            return true;
        }
        
        for (int edge : map.get(start)) {
            if (!visited[edge] && dfs(visited, map, edge, end)) {
                return true;
            }
        }
        
        return false;
    }
}
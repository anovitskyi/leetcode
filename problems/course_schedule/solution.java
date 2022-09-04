class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[0], x -> new ArrayList<>()).add(prereq[1]);
        }
        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(graph, i, visited, new HashSet<>())) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int curr, Set<Integer> visited, Set<Integer> path) {
        if (visited.contains(curr)) {
            return true;
        }
        
        if (path.contains(curr)) {
            return false;
        }
        path.add(curr);
        
        for (int next : graph.getOrDefault(curr, Collections.emptyList())) {
            if (!dfs(graph, next, visited, path)) {
                return false;
            }
        }
        
        visited.add(curr);
        return true;
    }
}
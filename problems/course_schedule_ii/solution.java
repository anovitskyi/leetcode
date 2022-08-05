class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) { 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prereq : prerequisites) {
            graph.computeIfAbsent(prereq[0], x -> new ArrayList<>()).add(prereq[1]);
        } 
        
        Set<Integer> result = new LinkedHashSet<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            boolean isPath = dfs(graph, i, result, new HashSet<>()); 
            if (!isPath) {
                return new int[0];
            }
        }
        
        int[] r = new int[numCourses];
        int i = 0;
        for (int el : result) {
            r[i++] = el;
        }
        return r;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int edge, Set<Integer> result, Set<Integer> path) {
        if (result.contains(edge)) {
            return true;
        }
        
        if (path.contains(edge)) {
            return false;
        }
        path.add(edge);
        
        
        for (int neighbour : graph.getOrDefault(edge, new ArrayList<>())) {
            boolean isPath = dfs(graph, neighbour, result, path);
            if (!isPath) {
                return false;
            }
        }
        
        result.add(edge);
        return true;
    }
}

/*

    [[0,1],[1,0]]
    
    0 -> [1]
    1 -> [0]
    
    0 <-> 1
    

*/
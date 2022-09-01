class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : prerequisites) {
            graph.computeIfAbsent(pair[0], x -> new ArrayList<>()).add(pair[1]);
        }
        
        Set<Integer> result = new LinkedHashSet<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(graph, result, i, new HashSet<>())) {
               return new int[0]; 
            }
        }
        
        int[] res = new int[numCourses];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }
        return res;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, Set<Integer> result, int currCourse, Set<Integer> path) {
        if (result.contains(currCourse)) {
            return true;
        }
        
        if (path.contains(currCourse)) {
            return false;
        }
        path.add(currCourse);
        
        for (int nextCourse : graph.getOrDefault(currCourse, Collections.emptyList())) {
            if (!dfs(graph, result, nextCourse, path)) {
                return false;
            }
        }
        
        result.add(currCourse);
        return true;
    }
}
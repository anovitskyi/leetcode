class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] p : prerequisites) {
            map.computeIfAbsent(p[0], x -> new ArrayList<>()).add(p[1]);
        }
        
        Set<Integer> result = new LinkedHashSet<>(numCourses);
        for (int i = 0; i < numCourses; ++i) {
            if (!dfs(map, i, result, new HashSet<>())) {
                return new int[0];
            }
        }
        
        int[] r = new int[numCourses];
        int i = 0;
        for (int num : result) {
            r[i++] = num;
        }
        return r;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int curr, Set<Integer> result, Set<Integer> path) {
        if (result.contains(curr)) {
            return true;
        }
        
        if (path.contains(curr)) {
            return false;
        }
        path.add(curr);
        
        for (int next : map.getOrDefault(curr, Collections.emptyList())) {
            if (!dfs(map, next, result, path)) {
                return false;
            }
        }
        
        result.add(curr);
        return true;
    }
}
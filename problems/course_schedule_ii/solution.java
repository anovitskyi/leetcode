class Solution {
    public int[] findOrder(int numCourses, int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>(numCourses);
        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[0], x -> new ArrayList<>()).add(pair[1]);
        }

        Set<Integer> path = new LinkedHashSet<>(numCourses);
        boolean[] visited = new boolean[numCourses];
        for (int course = 0; course < numCourses; ++course) {
            if (hasCycle(graph, course, path, visited)) {
                return new int[0];
            }
        }

        int[] result = new int[path.size()];
        int i = 0;
        for (int num : path) {
            result[i++] = num;
        }
        return result;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int course, Set<Integer> path, boolean[] visited) {
        if (visited[course]) {
            return true;
        }

        if (path.contains(course)) {
            return false;
        }

        visited[course] = true;

        for (int nextCourse : graph.getOrDefault(course, Collections.emptyList())) {
            if (hasCycle(graph, nextCourse, path, visited)) {
                return true;
            }
        }

        path.add(course);
        visited[course] = false;
        return false;
    }
}
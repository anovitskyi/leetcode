class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> graphIn = new HashMap<>();
        Map<Integer, List<Integer>> graphOut = new HashMap<>();
        for (int[] connection : connections) {
            graphOut.computeIfAbsent(connection[0], x -> new ArrayList<>()).add(connection[1]);
            graphIn.computeIfAbsent(connection[1], x -> new ArrayList<>()).add(connection[0]);
        }
        Set<Integer> visited = new HashSet<>();

        return visitCities(graphIn, graphOut, 0, visited);
    }

    private int visitCities(Map<Integer, List<Integer>> graphIn, Map<Integer, List<Integer>> graphOut, int city, Set<Integer> visited) {
        if (visited.contains(city)) {
            return 0;
        }
        visited.add(city);

        int result = 0;

        for (int nextCity : graphIn.getOrDefault(city, Collections.emptyList())) {
            result += visitCities(graphIn, graphOut, nextCity, visited);
        }

        for (int nextCity : graphOut.getOrDefault(city, Collections.emptyList())) {
            if (!visited.contains(nextCity)) {
                ++result;
            }
            result += visitCities(graphIn, graphOut, nextCity, visited);
        }

        return result;
    }
}
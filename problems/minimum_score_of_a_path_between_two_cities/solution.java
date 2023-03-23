class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = convertToGraph(roads);
        Set<Integer> visitedDistances = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int city = queue.poll();

            if (graph.get(city) == null) {
                continue;
            }

            for (int[] nextCityDetails : graph.get(city)) {
                queue.offer(nextCityDetails[0]);
                visitedDistances.add(nextCityDetails[1]);
            }
            graph.put(city, null);
        }

        int min = Integer.MAX_VALUE;
        for (int distance : visitedDistances) {
            if (distance < min) {
                min = distance;
            }
        }
        return min;
    }

    private Map<Integer, List<int[]>> convertToGraph(int[][] edges) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[] {edge[0], edge[2]});
        }
        return graph;
    }
}
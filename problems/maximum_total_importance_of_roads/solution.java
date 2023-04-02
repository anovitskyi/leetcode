class Solution {

    public long maximumImportance(int n, int[][] roads) {
        int[] graph = new int[n];
        for (int i = 0; i < roads.length; ++i) {
            graph[roads[i][0]]++;
            graph[roads[i][1]]++;
        }
        
        Arrays.sort(graph);
        
        long result = 0;
        for (int i = 0; i < graph.length; ++i) {
            result += graph[i] * 1L * (i + 1);
        }
        return result;
    }

    public long maximumImportance2(int n, int[][] roads) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], x -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], x -> new ArrayList<>()).add(road[0]);
        }

        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            int aSize = graph.containsKey(a) ? graph.get(a).size() : 0;
            int bSize = graph.containsKey(b) ? graph.get(b).size() : 0;

            return bSize - aSize;
        });
        for (int i = 0; i < n; ++i) {
            queue.offer(i);
        }

        Map<Integer, Integer> importance = new HashMap<>(n);

        long result = 0;
        while (!queue.isEmpty()) {
            int city = queue.poll();

            if (!importance.containsKey(city)) {
                importance.put(city, n--);
            }
            int cityImportance = importance.get(city);

            for (int nextCity : graph.getOrDefault(city, Collections.emptyList())) {
                if (!importance.containsKey(nextCity)) {
                    continue;
                }

                result += cityImportance + importance.get(nextCity);
            }
        }
        return result;
    }
}
class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;

        for (int[] row : dis) {
            Arrays.fill(row, 10001);
        }
            
        for (int[] e : edges) {
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        }
            
        for (int i = 0; i < n; ++i) {
            dis[i][i] = 0;
        }
            
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
        }
            
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j)
                if (dis[i][j] <= distanceThreshold)
                    ++count;
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }

    public int findTheCity2(int n, int[][] edges, int distanceThreshold) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(new int[] {edge[1], edge[2]});
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(new int[] {edge[0], edge[2]});
        }

        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue(), (a, b) -> {
                int weight = a[1] - b[1];
                if (weight != 0) {
                    return weight;
                }

                return a[0] - b[0];
            });
        }

        int[] result = new int[] {-1, Integer.MAX_VALUE};
        for (int city = 0; city < n; ++city) {
            Set<Integer> path = new HashSet<>();
            findPath(graph, city, distanceThreshold, path);

            if (path.size() <= result[1]) {
                result[0] = city;
                result[1] = path.size();
            }
        }
        return result[0];
    }

    private void findPath(Map<Integer, List<int[]>> graph, int city, int threshold, Set<Integer> visited) {
        if (threshold < 0 || visited.contains(city)) {
            return;
        }

        visited.add(city);

        for (int[] nextCity : graph.getOrDefault(city, Collections.emptyList())) {
            findPath(graph, nextCity[0], threshold - nextCity[1], visited);
        }

        return;
    }
}
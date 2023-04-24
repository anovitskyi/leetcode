class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[] {flight[1], flight[2]});
        }
        for (List<int[]> value : graph.values()) {
            Collections.sort(value, (a, b) -> b[1] - a[1]);
        }

        Map<Integer, Integer> routes = new HashMap<>();
        traverseRoutes(graph, routes, src, 0, k + 1);

        return routes.getOrDefault(dst, -1);
    }

    private void traverseRoutes(Map<Integer, List<int[]>> graph, Map<Integer, Integer> routes, int city, int price, int stops) {
        if (routes.getOrDefault(city, Integer.MAX_VALUE) <= price) {
            return;
        }
        routes.put(city, price);

        if (stops == 0) {
            return;
        }
        for (int[] nextCity : graph.getOrDefault(city, Collections.emptyList())) {
            traverseRoutes(graph, routes, nextCity[0], price + nextCity[1], stops - 1);
        }
    }
}
class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], x -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], x -> new ArrayList<>()).add(road[0]);
        }

        long result = 0;
        for (int nextCity : graph.getOrDefault(0, Collections.emptyList())) {
            result += calculateCost(graph, nextCity, 0, seats)[1];
        }
        return result;
    }

    private long[] calculateCost(Map<Integer, List<Integer>> graph, int city, int prevCity, int seats) {
        long people = 0;
        long fuel = 0;
        long cars = 0;

        for (int nextCity : graph.getOrDefault(city, Collections.emptyList())) {
            if (nextCity == prevCity) {
                continue;
            }

            long[] nextCityCost = calculateCost(graph, nextCity, city, seats);
            people += nextCityCost[0];
            fuel += nextCityCost[1];
        }

        people += 1;
        cars = (people / seats) + (people % seats != 0 ? 1 : 0);
        fuel += cars;
        
        return new long[] {people, fuel};
    }
}
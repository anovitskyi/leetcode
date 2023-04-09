class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>()).offer(ticket.get(1));
        }

        List<String> result = new ArrayList<>();
        traverseFlights(graph, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void traverseFlights(Map<String, Queue<String>> graph, String city, List<String> result) {
        Queue<String> nextAirports = graph.get(city);
        
        while (nextAirports != null && !nextAirports.isEmpty()) {
            traverseFlights(graph, nextAirports.poll(), result);
        }

        result.add(city);
    }
}
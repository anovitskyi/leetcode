class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, Queue<String>> graph = new HashMap<>();
        for (List<String> pair : tickets) {
            String from = pair.get(0);
            String to = pair.get(1);

            graph.computeIfAbsent(from, x -> new PriorityQueue<>()).offer(to);
        }

        List<String> result = new ArrayList<>();
        traverseAirports(graph, "JFK", result);
        Collections.reverse(result);
        return result;
    }

    private void traverseAirports(Map<String, Queue<String>> graph, String source, List<String> result) {
        Queue<String> nextAirports = graph.get(source);
        if (nextAirports != null) {
            while (!nextAirports.isEmpty()) {
                traverseAirports(graph, nextAirports.poll(), result);
            }
        }

        result.add(source);
    }
}
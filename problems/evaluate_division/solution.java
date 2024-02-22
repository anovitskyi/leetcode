class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); ++i) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double result = values[i];

            graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, result);
            graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0d / result);
        }

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            result[i] = calculate(a, b, graph, new HashSet<>());
        }
        return result;
    }

    private double calculate(String a, String b, Map<String, Map<String, Double>> graph, Set<String> visited) {
        if (!graph.containsKey(a) || !graph.containsKey(b)) {
            return -1.0d;
        }

        if (a.equals(b)) {
            return 1.0d;
        }

        if (graph.get(a).containsKey(b)) {
            return graph.get(a).get(b);
        }

        if (visited.contains(a)) {
            return -1.0d;
        }
        visited.add(a);
        
        for (String next : graph.get(a).keySet()) {
            double nextResult = calculate(next, b, graph, visited);

            if (nextResult < 0) {
                continue;
            }

            return graph.get(a).get(next) * nextResult;
        }

        return -1.0d;
    }
}
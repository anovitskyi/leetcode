class Solution {
    public int networkDelayTime(int[][] connections, int target, int source) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        Map<Integer, Integer> times = new HashMap<>();

        for (int[] connection : connections) {
            int from = connection[0];
            int[] to = new int[] {connection[1], connection[2]};

            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
        }

        for (List<int[]> list : graph.values()) {
            Collections.sort(list, (a, b) -> b[1] - a[1]);
        }

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {source, 0});

        while (!stack.isEmpty()) {
            int[] pop = stack.pop();
            int node = pop[0];
            int time = pop[1];
            
            if (time >= times.getOrDefault(node, Integer.MAX_VALUE)) {
                continue;
            }
            times.put(node, time);
            
            for (int[] neighbour : graph.getOrDefault(node, Collections.emptyList())) {
                stack.push(new int[] {neighbour[0], neighbour[1] + time});
            }
        }

        int result = -1;
        for (int node = 1; node <= target; ++node) {
            if (!times.containsKey(node)) {
                return -1;
            }

            result = Math.max(result, times.get(node));
        }
        return result;
    }
}
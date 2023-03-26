class Solution {
    public int[] loudAndRich(int[][] pairs, int[] quiet) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pair : pairs) {
            graph.computeIfAbsent(pair[1], x -> new ArrayList<>()).add(pair[0]);
        }

        int[] result = new int[quiet.length];
        for (int i = 0; i < result.length; ++i) {
            result[i] = Integer.MAX_VALUE;
        }

        for (int person = 0; person < result.length; ++person) {
            findQuiterAndRicher(graph, person, result, quiet);
        }
        return result;
    }

    private void findQuiterAndRicher(Map<Integer, List<Integer>> graph, int person, int[] result, int[] quiet) {
        if (result[person] != Integer.MAX_VALUE) {
            return;
        }

        int min = person;
        for (int next : graph.getOrDefault(person, Collections.emptyList())) {
            findQuiterAndRicher(graph, next, result, quiet);
            int nextMin = result[next];
            if (quiet[nextMin] < quiet[min]) {
                min = nextMin;
            }
        }

        result[person] = min;
    }
}
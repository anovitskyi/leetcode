class Solution {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> permutations = new LinkedList<>();
        for (int i = 1; i <= m; ++i) {
            permutations.add(i);
        }

        int[] queryPositions = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int query = queries[i];
            queryPositions[i] = permutations.indexOf(query);
            permutations.remove(queryPositions[i]);
            permutations.addFirst(query);
        }
        return queryPositions;
    }
}

/**
    [1, 3, 2, 4, 5]
    [2, 1, ]

 */
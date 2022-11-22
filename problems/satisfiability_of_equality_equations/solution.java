class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);

        for (String equation : equations) {
            if (equation.charAt(1) != '=') {
                continue;
            }

            int first = equation.charAt(0) - 'a';
            int second = equation.charAt(3) - 'a';

            uf.union(first, second);
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                continue;
            }

            int first = equation.charAt(0) - 'a';
            int second = equation.charAt(3) - 'a';

            if (uf.findRoot(first) == uf.findRoot(second)) {
                return false;
            }
        }

        return true;
    }

    private class UnionFind {
        private final int[] elements;

        UnionFind(int size) {
            elements = new int[size];
            for (int i = 0; i < size; ++i) {
                elements[i] = i;
            }
        }

        void union(int first, int second) {
            int firstRoot = findRoot(first);
            int secondRoot = findRoot(second);

            for (int i = 0; i < elements.length; ++i) {
                if (elements[i] == firstRoot) {
                    elements[i] = secondRoot;
                }
            }
        }

        int findRoot(int element) {
            while (elements[element] != element) {
                element = elements[element];
            }

            return elements[element];
        }
    }
}
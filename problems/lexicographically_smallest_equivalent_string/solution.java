class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind unionFind = new UnionFind(26);
        for (int i = 0; i < s1.length(); ++i) {
            int source = s1.charAt(i) - 'a';
            int target = s2.charAt(i) - 'a';
            unionFind.union(source, target);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            int source = baseStr.charAt(i) - 'a';
            char mappedChar = (char) (unionFind.find(source) + 'a');
            builder.append(mappedChar);
        }
        return builder.toString();
    }

    private static class UnionFind {
        private final int[] data;

        UnionFind(int size) {
            data = new int[size];
            for (int i = 0; i < size; ++i) {
                data[i] = i;
            }
        }

        void union(int source, int target) {
            int sourceValue = data[source];
            int targetValue = data[target];

            for (int i = 0; i < data.length; ++i) {
                if (data[i] == sourceValue) {
                    data[i] = targetValue;
                }
            }
        }

        int find(int target) {
            int targetValue = data[target];

            for (int i = 0; i < data.length; ++i) {
                if (data[i] == targetValue) {
                    return i;
                }
            }

            return -1;
        }
    }
}
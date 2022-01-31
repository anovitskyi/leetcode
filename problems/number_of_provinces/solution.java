class Solution {
    public int findCircleNum(int[][] isConnected) {
        QuickUnion qu = new QuickUnion(isConnected.length);
        for (int i = 0; i < isConnected.length; ++i) {
            for (int j = i; j < isConnected[i].length; ++j) {
                if (isConnected[i][j] == 1) {
                    qu.union(i, j);
                }
            }
        }
        return qu.findUniqueElements();
    }
    
    static class QuickUnion {
        
        private final int[] elements;
        
        QuickUnion(int size) {
            this.elements = new int[size];
            for (int i = 0; i < size; ++i) {
                elements[i] = i;
            }
        }
        
        void union(int source, int target) {
            int sourceRoot = root(source);
            int targetRoot = root(target);
            elements[sourceRoot] = targetRoot;
        }
        
        int root(int index) {
            int result = index;
            while (elements[result] != result) {
                result = elements[result];
            }
            return result;
        }
        
        int findUniqueElements() {
            Set<Integer> set = new HashSet<>();
            for (int elem : elements) {
                set.add(root(elem));
            }
            return set.size();
        }
        
    }
    
    static class QuickFind {
        
        private final int[] elements;
        
        QuickFind(int size) {
            this.elements = new int[size];
            for (int i = 0; i < size; ++i) {
                elements[i] = i;
            }
        }
        
        void union(int source, int target) {
            if (elements[source] == elements[target]) {
                return;
            }
            
            int prev = elements[source];
            int next = elements[target];
            for (int i = 0; i < elements.length; ++i) {
                if (elements[i] == prev) {
                    elements[i] = next;
                }
            }
        }
        
        int findUniqueElements() {
            Set<Integer> set = new HashSet<>();
            for (int elem : elements) {
                set.add(elem);
            }
            return set.size();
        }
        
    }
}
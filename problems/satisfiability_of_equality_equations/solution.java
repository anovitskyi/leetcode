class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        
        for (String equation : equations) {
            char[] tab = equation.toCharArray();
            
            if (tab[1] == '!') {
                continue;
            }
            
            unionFind.union(tab[0] - 'a', tab[3] - 'a');
        }
        
        for (String equation : equations) {
            char[] tab = equation.toCharArray();
            
            if (tab[1] == '=') {
                continue;
            }
            
            if (unionFind.find(tab[0] - 'a') == unionFind.find(tab[3] - 'a')) {
                return false;
            }
        }
        
        return true;
    }
    
    private class UnionFind {
        
        private final int[] data;
        
        UnionFind(int size) {
            data = new int[size];
            for (int i = 0; i < size; ++i) {
                data[i] = i;
            }
        }
        
        void union(int target, int source) {
            if (target == source) {
                return;
            }
            
            int t = find(target);
            int s = find(source);
            for (int i = 0; i < data.length; ++i) {
                if (data[i] == t) {
                    data[i] = s;
                }
            }
        }
        
        int find(int target) {
            while (data[target] != target) {
                target = data[target];
            }
            
            return target;
        }
    
    }
}
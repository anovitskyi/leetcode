class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] group = new int[][] {
            p1, p2, p3, p4
        };
        
        if (hasDuplicates(group)) {
            return false;
        }
        
        sortGroup(group);
        
        int distance = findDistance(group[0], group[1]);
        for (int i = 1; i < 4; ++i) {
            int next = (i + 1) % 4;
            if (findDistance(group[i], group[next]) != distance) {
                return false;
            }
        }
        
        return findDistance(group[0], group[2]) == findDistance(group[1],  group[3]);
    }
    
    private int findDistance(int[] p1, int[] p2) {
        int x = (p1[0] - p2[0]) * (p1[0] - p2[0]);
        int y = (p1[1] - p2[1]) * (p1[1] - p2[1]);
        
        return (int) Math.sqrt(x + y);
    }
    
    private void sortGroup(int[][] group) {
        for (int i = 0; i < 4; ++i) {
            for (int j = i + 1; j < 4; ++j) {
                if (group[i][0] < group[j][0]) {
                    int[] tmp = group[i];
                    group[i] = group[j];
                    group[j] = tmp;
                }
            }
        }
        
        if (group[0][1] > group[1][1]) {
            int[] tmp = group[0];
            group[0] = group[1];
            group[1] = tmp;
        }
        
        if (group[3][1] > group[2][1]) {
            int[] tmp = group[3];
            group[3] = group[2];
            group[2] = tmp;
        }
    }
    
    private boolean hasDuplicates(int[][] group) {
        Set<Integer> xSet = new HashSet<>(4);
        Set<Integer> ySet = new HashSet<>(4);
        int xCounter = 0;
        int yCounter = 0;
        
        for (int i = 0; i < 4; ++i) {
            if (!xSet.add(group[i][0])) {
                ++xCounter;
            }
            
            if (!ySet.add(group[i][1])) {
                ++yCounter;
            }
        }
        
        return xCounter > 2 || yCounter > 2;
    }
}
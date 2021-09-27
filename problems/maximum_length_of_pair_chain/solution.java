class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        
        int result = 0;
        for (int i = 0; i < pairs.length; ++i, ++result) {
            int tmp = i;
            while (tmp + 1 < pairs.length && pairs[tmp + 1][0] <= pairs[i][1]) {
                ++tmp;
            }
            i = tmp;
        }
        return result;
    }
}

// [-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]
// [-6,-2],[-5,3],[0,3],[-1,4],[1,6],[-9,8],[-6,9],[8,10]
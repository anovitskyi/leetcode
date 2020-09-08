class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        
        for (int i = 0; i < mat.length; ++i) {
            if (mat[i][0] == 0) {
                continue;
            }
            
            int index = 0;
            int left = 0;
            int right = mat[i].length - 1;
            while (left <= right) {
                index = (right + left) / 2;
                if (mat[i][index] == 0) {
                    if (mat[i][index - 1] == 1) {
                        break;
                    } else {
                        right = index - 1;
                    }
                } else {
                    left = index = index + 1;
                }
            }
            mat[i][0] = index;
        }
        
        for (int i = 0; i < mat.length && i < k; ++i) {
            int lowest = 0;
            
            for (int j = 0; j < mat.length; ++j) {
                if (mat[j][0] < mat[lowest][0]) {
                    lowest = j;
                }    
            }
            
            res[i] = lowest;
            mat[lowest][0] = Integer.MAX_VALUE;
        }
        
        return res;
    }
}
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        
        int[][] result = new int[r][c];
        int index = 0;
        
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                int x = index / c;
                int y = index % c;
                
                result[x][y] = mat[i][j];
                ++index;
            }
        }
        
        return result;
    }
}
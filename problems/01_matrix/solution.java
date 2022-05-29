class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[i].length; ++j) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                } else {
                    mat[i][j] *= -1;
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            
            if (x - 1 >= 0 && (mat[x - 1][y] == -1 || mat[x][y] + 1 < mat[x - 1][y])) {
                mat[x - 1][y] = mat[x][y] + 1;
                queue.offer(new int[] {x - 1, y});
            }
            
            if (x + 1 < mat.length && (mat[x + 1][y] == -1 || mat[x][y] + 1 < mat[x + 1][y])) {
                mat[x + 1][y] = mat[x][y] + 1;
                queue.offer(new int[] {x + 1, y});
            }
            
            if (y - 1 >= 0 && (mat[x][y - 1] == -1 || mat[x][y] + 1 < mat[x][y - 1])) {
                mat[x][y - 1] = mat[x][y] + 1;
                queue.offer(new int[] {x, y - 1});
            }
            
            if (y + 1 < mat[x].length && (mat[x][y + 1] == -1 || mat[x][y] + 1 < mat[x][y + 1])) {
                mat[x][y + 1] = mat[x][y] + 1;
                queue.offer(new int[] {x, y + 1});
            }
        }
        
        return mat;
    }
}

/*

    0 1 1 1
    1 1 1 0
    
    0  1  2  1
    1  2  1  0

*/
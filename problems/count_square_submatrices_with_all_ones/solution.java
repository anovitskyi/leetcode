class Solution {
    public int countSquares(int[][] matrix) {
        int result = 0;

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    continue;
                }

                if (i > 0 && j > 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
                }

                result += matrix[i][j];
            }
        }

        return result;
    }
}

/*

[
  [0,1,1,1],
  [1,0,1,1],
  [0,1,1,1]
]

[
  [0,1,1,1],
  [1,1,0,1],
  [1,2,1,1],
  [1,2,1,1],
  [1,1,1,1],
  [1,1,1,1]
]

 */
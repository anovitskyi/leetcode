class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int expectedSize = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(expectedSize);
        
        int startRow = 0;
        int endRow = matrix.length - 1;
        int currRow = 0;
        
        int startCol = 0;
        int endCol = matrix[0].length - 1;
        int currCol = 0;
        
        while (result.size() < expectedSize) {
            currRow = startRow;
            currCol = startCol;
            
            while (currCol <= endCol) {
                result.add(matrix[currRow][currCol]);
                ++currCol;
            }
            --currCol;
            ++currRow;
            
            if (result.size() >= expectedSize) {
                break;
            }
            
            while (currRow <= endRow) {
                result.add(matrix[currRow][currCol]);
                ++currRow;
            }
            --currCol;
            --currRow;
            
            if (result.size() >= expectedSize) {
                break;
            }
            
            while (currCol >= startCol) {
                result.add(matrix[currRow][currCol]);
                --currCol;
            }
            ++currCol;
            --currRow;
            
            if (result.size() >= expectedSize) {
                break;
            }
            
            while (currRow > startRow) {
                result.add(matrix[currRow][currCol]);
                --currRow;
            }
            
            ++startRow;
            ++startCol;
            
            --endRow;
            --endCol;
        }
        
        return result;
    }
}
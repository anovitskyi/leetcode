class Solution {
    
    public List<Integer> spiralOrder(int[][] matrix) {
       int size = matrix.length * matrix[0].length;
        List<Integer> result = new ArrayList<>(size);
        
        int rowStart = 0;
        int rowEnd = matrix.length;
        int columnStart = 0;
        int columnEnd = matrix[0].length;
        
        while (result.size() < size) {
            for (int i = columnStart; i < columnEnd; ++i) {
                result.add(matrix[rowStart][i]);
            }
            ++rowStart;
            if (result.size() >= size) {
                break;
            }
            
            for (int i = rowStart; i < rowEnd; ++i) {
                result.add(matrix[i][columnEnd - 1]);
            }
            --columnEnd;
            if (result.size() >= size) {
                break;
            }
            
            for (int i = columnEnd - 1; i >= columnStart; --i) {
                result.add(matrix[rowEnd - 1][i]);
            }
            --rowEnd;
            if (result.size() >= size) {
                break;
            }
            
            for (int i = rowEnd - 1; i >= rowStart; --i) {
                result.add(matrix[i][columnStart]);
            }
            ++columnStart;
            if (result.size() >= size) {
                break;
            }
        }
        
        return result;
    }
    
}
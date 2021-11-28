class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (containsWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean containsWord(char[][] board, int row, int column, String word, int position) {
        if (position >= word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length) {
            return false;
        }
        
        if (column < 0 || column >= board[0].length) {
            return false;
        }
        
        if (board[row][column] != word.charAt(position)) {
            return false;
        }
        
        char tmp = board[row][column];
        board[row][column] = ' ';
        boolean result = containsWord(board, row - 1, column, word, position + 1) || containsWord(board, row + 1, column, word, position + 1) || containsWord(board, row, column - 1, word, position + 1) || containsWord(board, row, column + 1, word, position + 1);
        board[row][column] = tmp;
        return result;
    }
}
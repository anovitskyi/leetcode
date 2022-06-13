class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (wordExist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean wordExist(char[][] board, int x, int y, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        
        if (x < 0 || x >= board.length) {
            return false;
        }
        
        if (y < 0 || y >= board[x].length) {
            return false;
        } 
        
        if (board[x][y] != word.charAt(index)) {
            return false;
        }
        
        char copy = board[x][y];
        board[x][y] = '0';
        
        boolean result = wordExist(board, x - 1, y, word, index + 1) || wordExist(board, x + 1, y, word, index + 1) || wordExist(board, x, y - 1, word, index + 1) || wordExist(board, x, y + 1, word, index + 1);
        
        board[x][y] = copy;
        return result;
    }
}
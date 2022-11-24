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

    private boolean wordExist(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        
        if (row < 0 || row >= board.length) {
            return false;
        }

        if (col < 0 || col >= board[row].length) {
            return false;
        }

        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        char tmp = board[row][col];
        board[row][col] = '.';

        boolean result = wordExist(board, row - 1, col, word, index + 1) || wordExist(board, row + 1, col, word, index + 1) || wordExist(board, row, col - 1, word, index + 1) || wordExist(board, row, col + 1, word, index + 1);

        board[row][col] = tmp;

        return result;
    }
}
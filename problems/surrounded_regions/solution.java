class Solution {
    public void solve(char[][] board) {
        for (int col = 0; col < board[0].length; ++col) {
            if (board[0][col] == 'O') {
                visitBorderRegion(board, 0, col);
            }
        }
        
        for (int col = 0; col < board[0].length; ++col) {
            if (board[board.length - 1][col] == 'O') {
                visitBorderRegion(board, board.length - 1, col);
            }
        }
        
        for (int row = 0; row < board.length; ++row) {
            if (board[row][0] == 'O') {
                visitBorderRegion(board, row, 0);
            }
        }
        
        for (int row = 0; row < board.length; ++row) {
            if (board[row][board[0].length - 1] == 'O') {
                visitBorderRegion(board, row, board[0].length - 1);
            }
        }
        
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[row].length; ++col) {
                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                } else if (board[row][col] == 'Q') {
                    board[row][col] = 'O';
                }
            }
        }
    }
    
    private void visitBorderRegion(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length) {
            return;
        }
        
        if (y < 0 || y >= board[x].length) {
            return;
        }
        
        if (board[x][y] != 'O') {
            return;
        }
        
        board[x][y] = 'Q';
        
        visitBorderRegion(board, x - 1, y);
        visitBorderRegion(board, x + 1, y);
        visitBorderRegion(board, x, y - 1);
        visitBorderRegion(board, x, y + 1);
    }
}
class Solution {

    private static final char WATER = 'X';
    private static final char LAND = 'O';
    private static final char BORDER_LAND = 'Q';

    public void solve(char[][] board) {
        for (int x = 0; x < board.length; ++x) {
            visitBorderLand(board, x, 0);
            visitBorderLand(board, x, board[x].length - 1);
        }

        for (int y = 0; y < board[0].length; ++y) {
            visitBorderLand(board, 0, y);
            visitBorderLand(board, board.length - 1, y);
        }

        for (int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[x].length; ++y) {
                if (board[x][y] == BORDER_LAND) {
                    board[x][y] = LAND;
                } else if (board[x][y] == LAND) {
                    board[x][y] = WATER;
                }
            }
        }
    }

    private void visitBorderLand(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) {
            return;
        }

        if (board[x][y] == BORDER_LAND || board[x][y] == WATER) {
            return;
        }

        board[x][y] = BORDER_LAND;

        visitBorderLand(board, x - 1, y);
        visitBorderLand(board, x + 1, y);
        visitBorderLand(board, x, y - 1);
        visitBorderLand(board, x, y + 1);
    }
}
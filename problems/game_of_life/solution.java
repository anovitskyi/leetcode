class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                int newState = getState(i, j, board);
                board[i][j] |= newState << 1;
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int getState(int i, int j, int[][] board) {
        int liveNeighbors = getLiveNeighbors(i, j, board);
        
        if (board[i][j] == 1) {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return 0;
            } else {
                return 1;
            }
        } else if (liveNeighbors == 3) {
            return 1;
        }
        
        return 0;
    }
    
    private int getLiveNeighbors(int row, int column, int[][] board) {
        int liveNeighbors = 0;
        
        int startRow = row == 0 ? row : row - 1;
        int endRow = row == board.length - 1 ? row : row + 1;
        int startColumn = column == 0 ? column : column - 1;
        int endColumn = column == board[row].length - 1 ? column : column + 1;
        
        for (int i = startRow; i <= endRow; ++i) {
            for (int j = startColumn; j <= endColumn; ++j) {
                liveNeighbors += board[i][j] & 1;
            }
        }
        
        return liveNeighbors - board[row][column];
    }
}
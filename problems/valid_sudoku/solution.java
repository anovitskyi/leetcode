class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < board[0].length; ++i) {
            if (!isValidColumn(board, i)) {
                return false;
            }
        }
        
        for (int i = 0; i < 9; ++i) {
            if (!isValidSquare(board, i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        boolean[] visited = new boolean[9];
        
        for (int i = 0; i < board[row].length; ++i) {
            if (!isValidChar(board[row][i], visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int column) {
        boolean[] visited = new boolean[9];
        
        for (int i = 0; i < board.length; ++i) {
            if (!isValidChar(board[i][column], visited)) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValidSquare(char[][] board, int square) {
        boolean[] visited = new boolean[9];
        int startRow = square - (square % 3);
        int endRow = startRow + 3;
        
        int startCol = (square % 3) * 3;
        int endCol = startCol + 3;
        
        for (int i = startRow; i < endRow; ++i) {
            for (int j = startCol; j < endCol; ++j) {
                if (!isValidChar(board[i][j], visited)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidChar(char ch, boolean[] visited) {
        if (ch == '.') {
            return true;
        }
        
        if (ch < '1' || ch > '9') {
            return false;
        }
        
        int num = ch - '0' - 1;
        if (visited[num]) {
            return false;
        }
        visited[num] = true;
        
        return true;
    }
}

/*

       0   1   2   3   4   5   6   7   8
    [[".",".",".",".","5",".",".","1","."], 0
     [".","4",".","3",".",".",".",".","."], 1
     [".",".",".",".",".","3",".",".","1"], 2
     ["8",".",".",".",".",".",".","2","."], 3
     [".",".","2",".","7",".",".",".","."], 4
     [".","1","5",".",".",".",".",".","."], 5
     [".",".",".",".",".","2",".",".","."], 6
     [".","2",".","9",".",".",".",".","."], 7
     [".",".","4",".",".",".",".",".","."]] 8

    col
    0 -> 0
    1 -> 3
    2 -> 6
    3 -> 0
    4 -> 3
    5 -> 6
    6 -> 0
    7 -> 3
    8 -> 6
    
    row
    0 -> 0
    1 -> 0
    2 -> 0
    3 -> 3
    4 -> 3
    5 -> 3
    6 -> 6
    7 -> 6
    8 -> 6
    
       0   1   2   3   4   5   6   7   8
    [[".","2",".",".",".",".",".",".","."], 0
     [".",".",".",".",".",".","5",".","1"], 1
     [".",".",".",".",".",".","8","1","3"], 2
     ["4",".","9",".",".",".",".",".","."], 3
     [".",".",".",".",".",".",".",".","."], 4
     [".",".","2",".",".",".",".",".","."], 5
     ["7",".","6",".",".",".",".",".","."], 6
     ["9",".",".",".",".","4",".",".","."], 7
     [".",".",".",".",".",".",".",".","."]] 8
*/
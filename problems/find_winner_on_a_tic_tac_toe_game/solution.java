class Solution {
    
    private static final String a = "A";
    private static final String b = "B";
    private static final String draw = "Draw";
    private static final String pending = "Pending";
    
    public String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return pending;
        }
        
        int[][] board = new int[3][3];
        int player = 1;
        
        for (int i = 0; i < moves.length; ++i, player *= -1) {
            board[moves[i][0]][moves[i][1]] = player;
        }
        
        if (isGameEnd(board, player * -1, moves[moves.length - 1])) {
                return translatePlayer(player * -1);
        }
        
        if (isGameEnd(board, player, moves[moves.length - 2])) {
            return translatePlayer(player);
        }
        
        return moves.length >= 9 ? draw : pending;
    }
    
    private String translatePlayer(int player) {
        return player == 1 ? a : b;
    }
    
    private boolean isGameEnd(int[][] board, int player, int[] lastMove) {
        return isEndByRow(board, player, lastMove[0]) || isEndByColumn(board, player, lastMove[1]) || isEndByDiagonales(board, player);
    }
    
    private boolean isEndByRow(int[][] board, int player, int row) {
        for (int i = 0; i < 3; ++i) {
            if (board[row][i] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isEndByColumn(int[][] board, int player, int column) {
        for (int i = 0; i < 3; ++i) {
            if (board[i][column] != player) {
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isEndByDiagonales(int[][] board, int player) {
        return isEndByLeftDiagonale(board, player) || isEndByRightDiagonale(board, player);
    }
    
    private boolean isEndByLeftDiagonale(int[][] board, int player) {
        for (int i = 0; i < 3; ++i) {
            if (board[i][i] != player) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEndByRightDiagonale(int[][] board, int player) {
        for (int i = 0; i < 3; ++i) {
            if (board[i][3 - i - 1] != player) {
                return false;
            }
        }
        return true;
    }
    
}
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int size = board.length;

        for (int row = 0; row < size; ++row) {
            if (!isValidRow(board, row)) {
                return false;
            }
        }

        for (int col = 0; col < size; ++col) {
            if (!isValidCol(board, col)) {
                return false;
            }
        }

        for (int block = 0; block < size; ++block) {
            if (!isValidBlock(board, block)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidRow(char[][] board, int row) {
        int size = board[row].length;
        boolean[] visited = new boolean[size];

        for (int col = 0; col < size; ++col) {
            if (board[row][col] == '.') {
                continue;
            }

            int index = board[row][col] - '0' - 1;
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
        }

        return true;
    }

    private boolean isValidCol(char[][] board, int col) {
        int size = board.length;
        boolean[] visited = new boolean[size];

        for (int row = 0; row < size; ++row) {
            if (board[row][col] == '.') {
                continue;
            }

            int index = board[row][col] - '0' - 1;
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
        }

        return true;
    }

    private boolean isValidBlock(char[][] board, int block) {
        int size = board.length;
        boolean[] visited = new boolean[size];

        for (int elem = 0; elem < size; ++elem) {
            int row = (block / 3 * 3) + (elem / 3);
            int col = (block % 3 * 3) + (elem % 3);

            if (board[row][col] == '.') {
                continue;
            }

            int index = board[row][col] - '0' - 1;
            if (visited[index]) {
                return false;
            }
            visited[index] = true;
        }

        return true;
    }
}
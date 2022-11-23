class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; ++row) {
            boolean[] numbers = new boolean[9];
            for (int col = 0; col < 9; ++col) {
                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }

                int num = ch - '0' - 1;
                if (numbers[num]) {
                    return false;
                }
                numbers[num] = true;
            }
        }

        for (int col = 0; col < 9; ++col) {
            boolean[] numbers = new boolean[9];
            for (int row = 0; row < 9; ++row) {
                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }

                int num = ch - '0' - 1;
                if (numbers[num]) {
                    return false;
                }
                numbers[num] = true;
            }
        }

        for (int block = 0; block < 9; ++block) {
            boolean[] numbers = new boolean[9];
            for (int element = 0; element < 9; ++element) {
                int row = (element / 3) + (3 * (block / 3));
                int col = (element % 3) + (3 * (block % 3));

                char ch = board[row][col];
                if (ch == '.') {
                    continue;
                }

                int num = ch - '0' - 1;
                if (numbers[num]) {
                    return false;
                }
                numbers[num] = true;
            }
        }

        return true;
    }
}

/*

    block = 0;
    element = 0;
    position = [0, 0];

    block = 0;
    element = 1;
    position = [0, 1];

    block = 0;
    element = 2;
    position = [0, 2];

    block = 0;
    element = 3;
    position = [1, 0];

    block = 0;
    element = 4;
    position = [1, 1];

    block = 0;
    element = 5;
    position = [1, 2];

    block = 0;
    element = 6;
    position = [2, 0];

    block = 0;
    element = 7;
    position = [2, 1];

    block = 0;
    element = 8;
    position = [2, 2];

    block = 1;
    element = 0;
    position = [0, 3];

    block = 1;
    element = 1;
    position = [0, 4];

    block = 1;
    element = 2;
    position = [0, 5]

    block = 1;
    element = 3;
    position = [1, 3]

    block = 4;
    element = 1;
    position = [3, 4]

 */
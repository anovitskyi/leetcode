class Solution {

    private static final char QUEEN_SPACE = 'Q';
    private static final char EMPTY_SPACE = '.';

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(n, curr, result);

        return result;
    }

    private void backtrack(int boardSize, List<String> curr, List<List<String>> result) {
        if (curr.size() == boardSize) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int queenPosition = 0; queenPosition < boardSize; ++queenPosition) {
            if (!isValidQueenPosition(queenPosition, curr)) {
                continue;
            }

            String row = createRow(boardSize, queenPosition);
            curr.add(row);
            backtrack(boardSize, curr, result);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isValidQueenPosition(int queenPosition, List<String> previousRows) {
        return isValidVerticalQueenPosition(queenPosition, previousRows) && isValidDiagonalQueenPosition(queenPosition, previousRows);
    }

    private boolean isValidVerticalQueenPosition(int queenPosition, List<String> previousRows) {
        for (String row : previousRows) {
            if (row.charAt(queenPosition) == QUEEN_SPACE) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidDiagonalQueenPosition(int queenPosition, List<String> previousRows) {
        for (int rowIndex = 0; rowIndex < previousRows.size(); ++rowIndex) {
            String row = previousRows.get(rowIndex);
            int diagonalOffset = previousRows.size() - rowIndex;

            int leftDiagonalPosition = queenPosition - diagonalOffset;
            if (leftDiagonalPosition >= 0 && row.charAt(leftDiagonalPosition) == QUEEN_SPACE) {
                return false;
            }

            int rightDiagonalPosition = queenPosition + diagonalOffset;
            if (rightDiagonalPosition < row.length() && row.charAt(rightDiagonalPosition) == QUEEN_SPACE) {
                return false;
            }
        }

        return true;
    }

    private String createRow(int size, int queenPosition) {
        char[] row = new char[size];
        
        for (int col = 0; col < size; ++col) {
            row[col] = EMPTY_SPACE;
        }
        row[queenPosition] = QUEEN_SPACE;

        return new String(row);
    }
}
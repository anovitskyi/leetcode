class SubrectangleQueries {
    
    private final LinkedList<Change> changes; // space - O(number of updateSubrectangle calls (max 500))
    private final int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
        this.changes = new LinkedList<>();
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        changes.addFirst(new Change(row1, row2, col1, col2, newValue));
    }
    
    public int getValue(int row, int col) { // time - O(number of updateSubrectangle calls (max 500))
        for (Change change : changes) {
            if (change.hasCoordinates(row, col)) {
                return change.val;
            }   
        }
        
        return rectangle[row][col];
    }
    
    private class Change {
        int fromRow;
        int toRow;
        int fromCol;
        int toCol;
        int val;
        
        Change(int fr, int tr, int fc, int tc, int v) {
            fromRow = fr;
            toRow = tr;
            fromCol = fc;
            toCol = tc;
            val = v;
        }
        
        boolean hasCoordinates(int row, int col) {
            return fromRow <= row && row <= toRow && fromCol <= col && col <= toCol;
        }
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */
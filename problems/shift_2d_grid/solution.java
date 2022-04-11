class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new LinkedList<>();
        int size = grid.length * grid[0].length;
        k %= size;
        
        for (int i = 0; i < grid.length; ++i) {
            List<Integer> row = new LinkedList<>();
            for (int j = 0; j < grid[i].length; ++j) {
                row.add(getPrevElement(grid, i, j, size, k));
            }
            result.add(row);
        }
        
        return result;
    }
    
    private int getPrevElement(int[][] grid, int i, int j, int size, int k) {
        int absoluteIndex = ((i * grid[i].length + j - k) + size) % size;
        int row = absoluteIndex / grid[i].length;
        int column = absoluteIndex % grid[i].length;
        
        return grid[row][column];
    }
}
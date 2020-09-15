class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> result = new LinkedList<>();
        
        int size = grid.length * grid[0].length;
        
        for (int i = 0; i < grid.length; ++i) {
            List<Integer> list = new LinkedList<>();
            
            for (int j = 0; j < grid[i].length; ++j) {
                
                int elem = i * grid[i].length + j - k;
                int index = elem % size;
                if (index < 0) {
                    index += size;
                }
                list.add(grid[index / grid[i].length][index % grid[i].length]);
                
            }
            
            result.add(list);
        }
        
        return result;
    }
}
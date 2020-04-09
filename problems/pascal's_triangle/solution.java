class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        
        List<Integer> row = Arrays.asList(1);
        List<Integer> prev = row;
        
        if (numRows > 0) {
            result.add(row);
        }
        
        for (int i = 1; i < numRows; ++i) {
            row = new ArrayList<>(i + 1);
            
            for (int j = 0; j < i + 1; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int left = prev.get(j - 1);
                    int right = prev.get(j);
                    
                    row.add(left + right);
                }
            }
            
            prev = row;
            result.add(row);
        }
        
        return result;
    }
}
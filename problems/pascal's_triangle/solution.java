class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }
        
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; ++i) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> actual = new ArrayList<>(i + 1);
            result.add(actual);
            
            for (int j = 0; j < i + 1; ++j) {
                int left = j - 1 < 0 ? 0 : prev.get(j - 1);
                int right = j >= prev.size() ? 0 : prev.get(j);
                
                actual.add(left + right);
            }
        }
        
        return result;
    }
}
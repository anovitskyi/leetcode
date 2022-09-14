class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> prev = List.of(1);
        result.add(prev);
        
        for (int i = 1; i < numRows; ++i) {
            int size = prev.size() + 1;
            List<Integer> curr = new ArrayList<>(size);
            
            for (int j = 0; j < size; ++j) {
                int p = j - 1 >= 0 ? prev.get(j - 1) : 0;
                int c = j < prev.size() ? prev.get(j) : 0;
                curr.add(p + c);
            }
            
            result.add(curr);
            prev = curr;
        }
        
        return result;
    }
}
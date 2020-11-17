class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        result.add(1);
        
        for (int row = 1; row <= rowIndex; ++row) {
            int size = row + 1;
            List<Integer> newList = new LinkedList<>();
            
            for (int i = 0; i < size; ++i) {
                int prev = i == 0 ? 0 : result.get(i - 1);
                int curr = i == row ? 0 : result.get(i);
                
                newList.add(prev + curr);
            }
            
            result = newList;
        }
        
        
        return result;
    }
}
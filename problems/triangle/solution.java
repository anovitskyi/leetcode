class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int minSum = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); ++i) {
            List<Integer> currList = triangle.get(i);
            List<Integer> prevList = triangle.get(i - 1);
            minSum = Integer.MAX_VALUE;
            for (int j = 0; j < currList.size(); ++j) {
                int currMinVal = currList.get(j) + getMinVal(prevList, j);
                minSum = Math.min(currMinVal, minSum);
                currList.set(j, currMinVal);
            }
        }
        
        return minSum;
    }
    
    private int getMinVal(List<Integer> prev, int index) {
        if (index - 1 < 0) {
            return prev.get(index);
        }
        
        if (index >= prev.size()) {
            return prev.get(index - 1);
        }
        
        return Math.min(prev.get(index), prev.get(index - 1));
    }
}
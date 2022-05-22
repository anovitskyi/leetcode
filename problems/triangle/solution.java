class Solution {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = triangle.get(0).get(0);
        
        for (int i = 1; i < triangle.size(); ++i) {
            result = Integer.MAX_VALUE;
            
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> curr = triangle.get(i);
            
            for (int j = 0; j < curr.size(); ++j) {
                int prevLeft = Integer.MAX_VALUE;
                if (j - 1 >= 0) {
                    prevLeft = prev.get(j - 1);
                }
                
                int prevRight = Integer.MAX_VALUE;
                if (j < prev.size()) {
                    prevRight = prev.get(j);
                } 
                int min = Math.min(prevLeft, prevRight) + curr.get(j);
                
                curr.set(j, min);
                result = Math.min(result, min);
            }
        }
        
        return result;
    }
}


/*

2
3 4
6 5 7
4 1 8 3


2
5  6
11 10 13
15 11 18 16


*/
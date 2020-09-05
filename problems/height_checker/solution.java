class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        
        int counter = 0;
        
        for (int i = 0; i < heights.length; ++i) {
            if (heights[i] != copy[i]) {
                ++counter;
            }
        }
        
        return counter;
    }
}
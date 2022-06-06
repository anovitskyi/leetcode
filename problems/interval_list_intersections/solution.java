class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        
        int first = 0;
        int second = 0;
        
        while (first < firstList.length && second < secondList.length) {
            int left = Math.max(firstList[first][0], secondList[second][0]);
            int right = Math.min(firstList[first][1], secondList[second][1]);
            
            if (left <= right) {
                result.add(new int[] {left, right});
            }
            
            if (firstList[first][1] <= secondList[second][1]) {
                ++first;
            } else {
                ++second;
            }
        }
        
        
        return result.toArray(new int[result.size()][2]);
    }
}
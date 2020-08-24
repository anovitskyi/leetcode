class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int i = 0; i < candies.length; ++i) {
            if (candies[i] > max) {
                max = candies[i];
            }
            
            candies[i] += extraCandies;
        }
        
        List<Boolean> list = new LinkedList<>();
        
        for (int i = 0; i < candies.length; ++i) {
            list.add(candies[i] >= max);
        }
        
        return list;
    }
}
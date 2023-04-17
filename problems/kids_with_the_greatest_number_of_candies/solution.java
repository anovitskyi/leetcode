class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for (int amount : candies) {
            max = Math.max(max, amount);
        }
        max -= extraCandies;

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int amount : candies) {
            result.add(amount >= max);
        }
        return result;
    }
}
class Solution {
    public int distributeCandies(int[] candies) {
        int half = candies.length / 2;
        Set<Integer> set = new HashSet<>(candies.length);
        for (int type : candies) {
            set.add(type);
            if (set.size() >= half) {
                return half;
            }
        }
        return set.size();
    }
}
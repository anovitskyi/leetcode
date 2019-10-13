class Solution {
    public int majorityElement(int[] nums) {
         Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int prev = map.getOrDefault(nums[i], 0);
            map.put(nums[i], prev + 1);
        }

        return map
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > nums.length / 2)
                .findAny()
                .map(entry -> entry.getKey())
                .orElse(-1);
    }
}
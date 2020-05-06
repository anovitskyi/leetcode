class Solution {
    public int majorityElement(int[] nums) {
        int maxCounter = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; ++i) {
            int counter = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], counter);
            
            if (counter > maxCounter) {
                maxCounter = counter;
                maxNum = nums[i];
            }
        }
        
        return maxNum;
     }
}
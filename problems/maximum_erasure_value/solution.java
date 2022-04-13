class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int result = 0;
        int currSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        while (right < nums.length) {
            int prevIndex = map.getOrDefault(nums[right], -1);
            while (left <= prevIndex) {
                currSum -= nums[left];
                ++left;
            }
            
            map.put(nums[right], right);
            currSum += nums[right];
            result = Math.max(result, currSum);
            ++right;
        }
        
        return result;
    }
}
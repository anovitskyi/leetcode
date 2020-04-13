class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        int first, second, third;
        first = second = third = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) {
                continue;
            }
            
            if (nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if (nums[i] > third) {
                third = nums[i];
            }
            
            set.add(nums[i]);
        }
        
        if (set.size() < 3) {
            return first;
        }
        
        return third;
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        
        int start = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] != 1) {
                if (i - 1 == start) {
                    result.add(nums[start] + "");
                } else {
                    result.add(nums[start] + "->" + nums[i - 1]);
                }
                start = i;
            }
        }
        
        if (start < nums.length - 1) {
            result.add(nums[start] + "->" + nums[nums.length - 1]);
        } else if (start == nums.length - 1) {
            result.add(nums[start] + "");
        }
        
        return result;
    }
}
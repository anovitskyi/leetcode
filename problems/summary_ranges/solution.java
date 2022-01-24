class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int left = i;
            int right = i;
            
            while (right + 1 < nums.length && nums[right + 1] - nums[right] == 1) {
                ++right;
            }
            
            if (left == right) {
                result.add(nums[left] + "");
            } else {
                result.add(nums[left] + "->" + nums[right]);
            }
            
            i = right;
        }
        
        return result;
    }
}
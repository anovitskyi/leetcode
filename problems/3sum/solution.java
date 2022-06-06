class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            findSum(nums, i, result);
        }
        
        return result;
    }
    
    private void findSum(int[] nums, int start, List<List<Integer>> result) {
        int left = start + 1;
        int right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum + nums[start] == 0) {
                result.add(Arrays.asList(nums[start], nums[left], nums[right]));
                do {
                    ++left;
                } while (left < right && nums[left] == nums[left - 1]);
                
                do {
                    --right;
                } while (left < right && nums[right] == nums[right + 1]);
            } else if (sum + nums[start] > 0) {
                --right;
            } else {
                ++left;
            }
        }
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int left = i + 1;
            int right = nums.length - 1;
            int negative = 0 - nums[i];
            while (left < right) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    ++left;
                    continue;
                }
                
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    --right;
                    continue;
                }
                
                int sum = nums[left] + nums[right];
                if (sum == negative) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    ++left;
                    --right;
                } else if (sum > negative) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        
        return result;
    }
}

// [-1,0,1,2,-1,-4]
// [-4,-1,-1,0,1,2]

// [-2,0,0,2,2]
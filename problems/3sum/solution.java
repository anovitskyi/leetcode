class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            List<List<Integer>> twoSums = twoSum(nums, i + 1, nums.length - 1, 0 - nums[i]);
            
            for (List<Integer> twoSum : twoSums) {
                twoSum.add(nums[i]);
                result.add(twoSum);
            }
        }
        
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int l, int r, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int left = l;
        int right = r;

        while (left < right) {
            if (left > l && nums[left] == nums[left - 1]) {
                ++left;
                continue;
            }

            if (right < r && nums[right] == nums[right + 1]) {
                --right;
                continue;
            }

            int sum = nums[left] + nums[right];

            if (sum == target) {
                List<Integer> twoSum = new ArrayList<>();
                twoSum.add(nums[left]);
                twoSum.add(nums[right]);
                result.add(twoSum);

                ++left;
                --right;
            } else if (sum > target) {
                --right;
            } else {
                ++left;
            }
        }

        return result;
    }
}
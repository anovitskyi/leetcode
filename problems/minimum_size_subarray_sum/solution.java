class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        
        while (right <= nums.length) {
            if (sum >= target) {
                result = Math.min(result, right - left);
                sum -= nums[left];
                ++left;
            } else if (right < nums.length) {
                sum += nums[right];
                ++right;
            } else {
                break;
            }
        }
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

/*

left               |
array   [2,3,1,2,4,3]
right                |

sum = 3
target = 7
result = 2
 
*/
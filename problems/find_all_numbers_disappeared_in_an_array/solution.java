class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = 0 - nums[index];
            }
        }
        
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}


// 1. Bruteforce - O(n^2). Manually check each number in range [1, n] whether it appears in array nums
// 2. Sort array nums - O(nlogn). Then manually check each number in range [1, n] using binary search.
// 3. Store elements in boolean array. Then return only "false" (not populated) indicies.
// 4. Mark each index as mark, by making it negative. Then add to result only positive indexes - O(n)

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            int num = Math.abs(nums[i]);
            int index = num - 1;
            
            if (nums[index] < 0) {
                result.add(num);
            } else {
                nums[index] = 0 - nums[index];
            }
        }
        
        return result;
    }
}


// 1. Bruteforce - O(n^2). Find duplicates for each element in nested loop
// 2. Sort array and the find duplicates in single iteration - O(logn)
// 3. Mark indicies as visited by making them negative. When negative element will be found, that means it was previously visited and is a duplicate - O(n)
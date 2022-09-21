class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                sum += num;
            }
        }
        
        for (int i = 0; i < result.length; ++i) {
            int value = queries[i][0];
            int index = queries[i][1];
            
            int prev = nums[index];
            if (prev % 2 == 0) {
                sum -= prev;
            }
            
            int next = prev + value;
            if (next % 2 == 0) {
                sum += next;
            }
            
            nums[index] = next;
            result[i] = sum;
        }
        return result;
    }
}
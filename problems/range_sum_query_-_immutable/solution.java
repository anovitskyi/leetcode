class NumArray {
    
    private final int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        int leftSum = left - 1 < 0 ? 0 : prefixSum[left - 1];
        int rightSum = prefixSum[right];
        return rightSum - leftSum;
    }
}
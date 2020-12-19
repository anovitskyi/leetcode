class NumArray {
    
    private int[] arr;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] = nums[i] + nums[i - 1];
        }
        
        arr = nums;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return arr[j];
        }
        
        return arr[j] - arr[i - 1];
    }
}

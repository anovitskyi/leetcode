class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        
        for (int i = 0; i < target.length; ++i) {
            int in = index[i];
            int num = nums[i];
            
            int copy = target[in];
            target[in] = num;
            
            for (int j = in + 1; j < target.length; ++j) {
                int tmp = target[j];
                target[j] = copy;
                copy = tmp;
            }
        }
        
        return target;
    }
}
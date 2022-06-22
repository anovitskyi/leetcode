class Solution {

    private final int[] original;
    private final int[] copy;
    
    public Solution(int[] nums) {
        this.original = nums;
        this.copy = new int[nums.length];
        reset();
    }
    
    public int[] reset() {
        for (int i = 0; i < original.length; ++i) {
            copy[i] = original[i];
        }
        
        return copy;
    }
    
    public int[] shuffle() {
        Random rand = new Random();
        for (int i = 0; i < copy.length; ++i) {
            int randIndex = rand.nextInt(copy.length);
            int tmp = copy[randIndex];
            copy[randIndex] = copy[i];
            copy[i] = tmp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
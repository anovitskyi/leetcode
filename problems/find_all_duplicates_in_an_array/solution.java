class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] tab = new boolean[nums.length];
        
        List<Integer> dups = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = nums[i] - 1;
            if (tab[index]) {
                dups.add(nums[i]);
            } else {
                tab[index] = true;
            }
        }
        
        return dups;
    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int indexToUpdate = nums[i] - 1;
            
            while (nums[indexToUpdate] - 1 != indexToUpdate) {
                int copy = nums[indexToUpdate] - 1;
                nums[indexToUpdate] = indexToUpdate + 1;
                indexToUpdate = copy;
            }
        }
        
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
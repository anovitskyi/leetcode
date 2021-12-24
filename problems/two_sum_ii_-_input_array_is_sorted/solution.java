class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int index = findIndex(target - numbers[i], numbers, i + 1, numbers.length - 1);
            if (index > 0) {
                return new int[] {
                    i + 1, index + 1
                };
            }
        }
        
        return null;
    }
    
    private int findIndex(int target, int[] numbers, int left, int right) {
        if (left > right) {
            return -1;
        }
        
        int middle = ((right - left) / 2) + left;
        if (numbers[middle] == target) {
            return middle;
        } else if (numbers[middle] > target) {
            return findIndex(target, numbers, left, middle - 1);
        } else {
            return findIndex(target, numbers, middle + 1, right);
        }
    }
}
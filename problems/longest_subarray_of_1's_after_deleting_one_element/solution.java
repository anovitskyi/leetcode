class Solution {
    public int longestSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int counter = 0;
        for (int num : nums) {
            if (num == 0) {
                list.add(counter);
                counter = 0;
            } else {
                ++counter;
            }
        }
        list.add(counter);
        
        int max = counter == 0 ? 0 : counter - 1;
        for (int i = 1; i < list.size(); ++i) {
            int sum = list.get(i) + list.get(i - 1);
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
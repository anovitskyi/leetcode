class Solution {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int num : nums) {
            int counter = map.getOrDefault(num, 0);
            
            if (counter == 0) {
                sum += num;
            } else if (counter == 1) {
                sum -= num;
            }
            
            map.put(num, counter + 1);
        }
        
        return sum;
    }
}
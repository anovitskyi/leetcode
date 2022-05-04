class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        
        for (int num : nums) {
            int diff = k - num;
            
            int counter = map.getOrDefault(diff, 0);
            if (counter > 0) {
                ++result;
                map.put(diff, counter - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);   
            }
        }
        
        return result;
    }
}

/*

    1. Create visited elements map (element -> quantity)
    2. Iterate each num in nums
    3. Calculate diff between k and num
    4. If diff is in map (diff + num == k) -> increase result counter and dicrease quantity of diff
    5. Otherwise -> increase quantity of num

*/
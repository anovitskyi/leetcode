class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            
            int mod = sum % k;
            if (!map.containsKey(mod)) {
                map.put(mod, i + 1);
            } else if (map.get(mod) < i) {
                return true;
            }
        }
        
        return false;
    }
}

/*

    [23,  2,  4,  6,  7]
    [23, 25, 29, 35, 42]
    [ 5,  0,  5,  ]


    
    [23,  2,  4,  6,  6]
    [23, 25, 29, 35, 41]
    [ 2,  4,  1,  0,  6]
*/
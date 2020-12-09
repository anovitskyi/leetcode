class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 1);
        }
        
        int size = 0;
        for (int num : nums2) {
            int q = map.getOrDefault(num, 0);
            if (q > 0) {
                map.put(num, q + 1);
                if (q == 1) {
                    ++size;   
                }
            }
            
        }
        
        int[] result = new int[size];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result[--size] = entry.getKey();
            }
        }
        return result;
    }
}
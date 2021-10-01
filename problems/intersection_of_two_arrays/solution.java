class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, false);
        }
        
        int size = 0;
        for (int num : nums2) {
            Boolean visited = map.get(num);
            if (visited == null || visited) {
                continue;
            }
        
            ++size;
            map.put(num, true);
        }
        
        int[] result = new int[size];
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                result[--size] = entry.getKey();
            }
        }
        return result;
    }
}
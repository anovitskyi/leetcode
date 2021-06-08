class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] small = nums1.length <= nums2.length ? nums1 : nums2;
        int[] big = nums1.length > nums2.length ? nums1 : nums2;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : small) {
            int counter = map.getOrDefault(num, 0);
            map.put(num, counter + 1);
        }
        
        int size = 0;
        for (int num : big) {
            if (map.containsKey(num)) {
                int counter = map.get(num);
                map.put(num, counter - 1);
                if (counter >= 1) {
                    small[size++] = num;   
                }
            }
        }
        
        int[] result = new int[size];
        for (int i = 0; i < size; ++i) {
            result[i] = small[i];
        }
        return result;
    }
}
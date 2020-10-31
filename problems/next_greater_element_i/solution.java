class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; ++i) {
            map.put(nums2[i], i);    
        }
        
        
        for (int i = 0; i < nums1.length; ++i) {
            int copy = nums1[i];
            nums1[i] = -1;
            int index = map.get(copy);
            for (int j = index + 1; j < nums2.length; ++j) {
                if (nums2[j] > copy) {
                    nums1[i] = nums2[j];
                    break;
                }
            }
        }
        
        return nums1;
    }
}
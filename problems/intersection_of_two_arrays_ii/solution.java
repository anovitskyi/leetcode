class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        int n1 = 0;
        int n2 = 0;
        while (true) {
            if (n1 >= nums1.length || n2 >= nums2.length) {
                int[] res = new int[result.size()];
                for (int i = 0; i < result.size(); ++i) {
                    res[i] = result.get(i);
                }
                return res;
            }
            
            if (nums1[n1] == nums2[n2]) {
                result.add(nums1[n1]);
                ++n1;
                ++n2;
            } else if (nums1[n1] > nums2[n2]) {
                ++n2;
            } else if (nums2[n2] > nums1[n1]) {
                ++n1;
            }
        }
    }
}
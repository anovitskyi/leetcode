class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int[] tab = new int[1001];
        int f = 0;
        int s = 0;
        
        while (f < nums1.length || s < nums2.length) {
            if (f < nums1.length) {
                if (tab[nums1[f]]++ < 0) {
                    result.add(nums1[f]);
                }
                ++f;
            }
            
            if (s < nums2.length) {
                if (tab[nums2[s]]-- > 0) {
                    result.add(nums2[s]);
                }
                ++s;   
            }
        }
        
        int[] r = new int[result.size()];
        int i = 0;
        for (int num : result) {
            r[i++] = num;
        }
        return r;
    }
}
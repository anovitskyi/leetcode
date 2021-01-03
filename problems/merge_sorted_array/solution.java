class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        --m;
        --n;
        for (int i = nums1.length - 1; i >= 0; --i) {
            int elem = -1;
            if (n < 0) {
                elem = nums1[m--];
            } else if (m < 0) {
                elem = nums2[n--];  
            } else if (nums1[m] >= nums2[n]) {
                elem = nums1[m--];
            } else {
                elem = nums2[n--];
            }
            
            nums1[i] = elem;
        }
    }
}
// -10 -9 -8 -5 0 0 0 0 | 4
// 100 101 102 104 | 4
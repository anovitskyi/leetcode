class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        --m; --n;
        
        for (int i = nums1.length - 1; i >= 0; --i) {
            if (m < 0) {
                nums1[i] = nums2[n--];
            } else if (n < 0) {
                nums1[i] = nums1[m--];
            } else if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m--];
            } else {
                nums1[i] = nums2[n--];
            }
        }
    }
}

// 1. Bruteforce solution. O(n) - time and O(n) space. Using two pointers (one for nums1 and another for nums2) on each iteration find minimum element and put it in result array

// 2. Using two pointer store max element on each iteration in the end of nums1 array
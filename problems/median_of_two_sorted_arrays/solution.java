class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int finalArraySize = nums1.length + nums2.length;
        int i1 = 0;
        int i2 = 0;
        
        int[] middleNumbers = new int[2];
        while (i1 < nums1.length || i2 < nums2.length) {
            if (i1 + i2 > finalArraySize / 2) {
                if (finalArraySize % 2 == 1) {
                    return middleNumbers[1];
                } else {
                    return (middleNumbers[1] + middleNumbers[0]) / 2.0d;
                }
            }
            
            int min = -1;
            if (i1 >= nums1.length) {
                min = nums2[i2++];
            } else if (i2 >= nums2.length) {
                min = nums1[i1++];
            } else if (nums1[i1] < nums2[i2]) {
                min = nums1[i1++];
            } else {
                min = nums2[i2++];
            }
            middleNumbers[0] = middleNumbers[1];
            middleNumbers[1] = min;
        }
        
        if (finalArraySize % 2 == 1) {
            return middleNumbers[1];
        } else {
            return (middleNumbers[1] + middleNumbers[0]) / 2.0d;
        }
    }
}
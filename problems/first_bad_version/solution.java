/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return findBadVersion(1, n);
    }
    
    private int findBadVersion(int start, int end) {
        if (start >= end) {
            return start;
        }
        
        int middle = start + (end - start) / 2;
        
        if (isBadVersion(middle)) {
            return findBadVersion(start, middle);
        } else {
            return findBadVersion(middle + 1, end);
        }
    }
}
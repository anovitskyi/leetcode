class Solution {
    public int smallestRangeI(int[] A, int K) {
        if (A.length < 2) {
            return 0;
        }
        
        int min = 10_001;
        int max = -1;
        
        for (int a : A) {
            if (a < min) {
                min = a;
            }
            
            if (a > max) {
                max = a;
            }
        }
        
        min += K;
        max -= K;
        int diff = max - min;
        
        if (diff <= 0) {
            return 0;
        } else {
            return diff; 
        }
    }
}

// [1, 3, 16] k=3
// min = 1 => 4
// max = 16 => 13
// diff = 13 - 4 = 9
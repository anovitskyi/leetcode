class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        
        int left = 1;
        int right = x;
        
        while (left <= right) {
            int middle = ((right - left) / 2) + left;
            int num = x / middle;
            
            if (num == middle) {
                return middle;
            } else if (num < middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        
        return right;
    }
    
//     public int mySqrt(int x) {
//         if (x < 2) {
//             return x;
//         }
//         return sqrt(x, 1, x);
//     }
    
//     private int sqrt(int x, int left, int right) {
//         if (left > right) {
//             return right;
//         }
        
//         int middle = ((right - left) / 2) + left;
//         int num = x / middle;
        
//         if (num == middle) {
//             return middle;
//         } else if (middle > num) {
//             return sqrt(x, left, middle - 1);
//         } else {
//             return sqrt(x, middle + 1, right);
//         }
//     }
}
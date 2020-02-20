class Solution {
//     public int numberOfSteps (int num) {
        
//         if (num == 0) {
//             return 0;
//         } else if (num % 2 == 1) {
//             num -= 1;
//         } else {
//             num /= 2;
//         }
        
//         return 1 + numberOfSteps(num);
//     }
    
    public int numberOfSteps (int num) {
        int counter = 0;
        while (num > 0) {
            ++counter;
            
            if (num % 2 == 1) {
                --num;
            } else {
                num /= 2;
            }
        }
        
        return counter;
    }
}
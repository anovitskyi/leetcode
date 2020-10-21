class Solution {
    
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
    
//     public boolean divisorGame(int N) {
//         boolean isAlice = true; // true
        
//         while (N-- > 1) { // 1
//             isAlice = !isAlice;
//         }
        
//         return !isAlice;
//     }
    
    
//     public boolean divisorGame(int N) {
//         boolean isAlice = true;
//         while (true) {
//             boolean isFound = false;
//             for (int i = 1; i < N; ++i) {
//                 if (N % i == 0) { 
//                     isFound = true;
//                     N -= i;
//                     break;
//                 }
//             }
            
//             if (!isFound) {
//                 return !isAlice;
//             }
//             isAlice = !isAlice;
//         }
//     }
}
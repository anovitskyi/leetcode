class Solution {
//     public char nextGreatestLetter(char[] letters, char target) {
//         for (int i = 0; i < letters.length; ++i) {
//             if (letters[i] > target) {
//                 return letters[i];
//             }
//         }
        
//         return letters[0];
//     }
    
    public char nextGreatestLetter(char[] letters, char target) {
        int diff = Integer.MAX_VALUE;
        char result = '0';
        
        for (char letter : letters) {
            if (letter == target) {
                continue;
            }
            
            int currDiff = letter - target;
            if (currDiff < 0) {
                currDiff = 26 + currDiff;
            }
            if (currDiff < diff) {
                diff = currDiff;
                result = letter;
            }
        }
        
        return result;
    }
}
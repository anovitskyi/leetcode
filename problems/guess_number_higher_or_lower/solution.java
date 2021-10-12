public class Solution extends GuessGame {
    
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        
        while (left <= right) {            
            int middle = ((right - left) / 2) + left;
            int result = guess(middle);
            
            if (result == 0) {
                return middle;
            } else if (result > 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return -1;
    }
}
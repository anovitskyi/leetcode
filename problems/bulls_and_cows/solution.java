class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int secretCh = secret.charAt(i) - '0';
            int guessCh = guess.charAt(i) - '0';
            
            if (secretCh == guessCh) {
                ++bulls;
                continue;
            }
            
            ++map[secretCh];
            if (map[secretCh] <= 0) {
                ++cows;
            }
            
            --map[guessCh];
            if (map[guessCh] >= 0) {
                ++cows;
            }
        }
    
        return bulls + "A" + cows + "B";
    }
}

/*
        |
    "1122"
    "2211"
    
    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    bulls = 0;
    cows = 0;

*/
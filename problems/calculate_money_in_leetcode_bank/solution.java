class Solution {
    public int totalMoney(int n) {
        int result = 0;
        int weekFee = 28;
        int mondayFee = 1;
        
        while (n >= 7) {
            result += weekFee;
            
            weekFee += 7;
            ++mondayFee;
            n -= 7;
        }
        
        for (int i = 0; i < n; ++i) {
            result += mondayFee;
            ++mondayFee;
        }
        
        return result; 
    }
}
class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            int copy = 0;
            while (num > 0) {
                copy += num % 10;
                num /= 10;
            }
            num = copy;
        }
        
        return num;
    }
}
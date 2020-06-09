class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        
        StringBuilder b = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num *= -1;
        }
        
        while (num > 0) {
            b.append(num % 7);
            num /= 7;
        }
        
        if (negative) {
            b.append("-");
        }
        return b.reverse().toString();
    }
}
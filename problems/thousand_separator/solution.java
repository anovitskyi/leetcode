class Solution {
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        
        StringBuilder b = new StringBuilder();
        int counter = 0;
        
        while (n > 0) {
            b.append(n % 10);
            if ((n = n / 10) != 0 && ++counter == 3) {
                b.append(".");
                counter = 0;
            }
        }
        
        return b.reverse().toString();
    }
}

// 111222333444
// 11122233344
// 1112223334
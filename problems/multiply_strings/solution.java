class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        if (num1.equals("1")) {
            return num2;
        }
        
        if (num2.equals("1")) {
            return num1;
        }
        
        String result = "";
        String indentation = "";
        
        for (int i = num2.length() - 1; i >= 0; --i) {
            int digit = num2.charAt(i) - '0';
            String mult = multiplyOneDigit(num1, digit) + indentation;
            result = sum(result, mult);
            indentation += "0";
        }
        
        return result;
    }
    
    private String multiplyOneDigit(String num, int digit) {
        if (digit == 0) {
            return "0";
        }
        
        if (digit == 1) {
            return num;
        }
        
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        
        for (int i = num.length() - 1; i >= 0; --i) {
            int m = (num.charAt(i) - '0') * digit + carry;
            builder.append(m % 10);
            carry = m / 10;
        }
        
        if (carry != 0) {
            builder.append(carry);
        }
        
        return builder.reverse().toString();
    }
    
    private String sum(String numA, String numB) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        
        int aIndex = numA.length() - 1;
        int bIndex = numB.length() - 1;
        
        while (aIndex >= 0 && bIndex >= 0) {
            int a = numA.charAt(aIndex) - '0';
            int b = numB.charAt(bIndex) - '0';
            
            int s = a + b + carry;
            builder.append(s % 10);
            carry = s / 10;
            
            --aIndex;
            --bIndex;
        }
        
        while (aIndex >= 0) {
            int a = numA.charAt(aIndex) - '0';
            
            int s = a + carry;
            builder.append(s % 10);
            carry = s / 10;
            
            --aIndex;
        }
        
        while (bIndex >= 0) {
            int b = numB.charAt(bIndex) - '0';
            
            int s = b + carry;
            builder.append(s % 10);
            carry = s / 10;
            
            --bIndex;
        }
        
        if (carry != 0) {
            builder.append(carry);
        }
        
        return builder.reverse().toString();
    }
}
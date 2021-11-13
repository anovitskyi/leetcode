class Solution {
    
    private static final String UNDEFINED = "Undefined";
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        Stack<String> stack = new Stack<>();
        int level = 0;
        while (num > 0) {
            String word = toWord(num % 1000, level);
            if (!word.isEmpty()) {
                stack.push(word);   
            }
            num /= 1000;
            ++level;
        }
        
        return convertToString(stack);
    }
    
    private String toWord(int num, int level) {
        StringBuilder b = new StringBuilder();
        int units = num % 10;
        num /= 10;
        int dozens = num % 10;
        num /= 10;
        int hundreds = num % 10;
            
        if (hundreds > 0) {
            b.append(toNumber(hundreds)).append(" Hundred");
        }
            
        if (dozens > 0) {
            if (b.length() > 0) {
                b.append(" ");
            }   
            
            if (dozens == 1) {
                b.append(toTwentyDozens(dozens * 10 + units));
            } else {
                b.append(toDozens(dozens));
            }
        }
        
        if (units > 0 && dozens != 1) {
            if (b.length() > 0) {
                b.append(" ");
            }
            
            b.append(toNumber(units));
        }
    
        if (b.length() > 0) {
            b.append(toLevel(level));
        }
        
        return b.toString();
    }
    
    private String toNumber(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        
        return UNDEFINED;
    }
    
    private String toTwentyDozens(int num) {
        switch (num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        
        return UNDEFINED;
    }
    
    private String toDozens(int num) {
        switch (num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        
        return UNDEFINED;
    }
    
    private String toLevel(int level) {
        switch (level) {
            case 0: return "";
            case 1: return " Thousand";
            case 2: return " Million";
            case 3: return " Billion";
        }
        
        return UNDEFINED;
    }
    
    private String convertToString(Stack<String> stack) {
        StringBuilder b = new StringBuilder();
        String sep = "";
        while (!stack.isEmpty()) {
            b.append(sep).append(stack.pop());
            sep = " ";
        }
        return b.toString();
    }
    
}
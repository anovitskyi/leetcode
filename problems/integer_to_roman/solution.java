class Solution {
    
    private static final Map<Integer, Character> map = new HashMap<>();
    
    static {
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
    }
    
    public String intToRoman(int num) {
        Stack<String> stack = new Stack<>();
        for (int level = 1; num > 0; level *= 10, num /= 10) {
            stack.push(convert(num % 10, level));
        }
        
        StringBuilder b = new StringBuilder();
        while (!stack.isEmpty()) {
            b.append(stack.pop());
        }
        return b.toString();
    }
    
    private String convert(int num, int level) {
        char curr = map.get(level);
        char half = map.getOrDefault(level * 5, '0');
        char next = map.getOrDefault(level * 10, '0');
        
        switch (num) {
            case 1: return "" + curr;
            case 2: return "" + curr + curr;
            case 3: return "" + curr + curr + curr;
            case 4: return "" + curr + half;
            case 5: return "" + half;
            case 6: return "" + half + curr;
            case 7: return "" + half + curr + curr;
            case 8: return "" + half + curr + curr + curr;
            case 9: return "" + curr + next;
            default: return "";
        }
    }
}
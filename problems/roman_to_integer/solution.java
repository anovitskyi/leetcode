class Solution {
    
    private static final Map<Character, Integer> map = new HashMap<>();
    
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    
    /**
        49 -> ILIX
    
    **/
    
    public int romanToInt(String s) {
        int result = map.get(s.charAt(0));
        
        for (int i = 1; i < s.length(); ++i) {
            int prev = map.get(s.charAt(i - 1));
            int curr = map.get(s.charAt(i));
            
            if (curr <= prev) {
                result += curr;
            } else {
                result += (curr - prev - prev);
            }
        }
        
        return result;
    }
    
}
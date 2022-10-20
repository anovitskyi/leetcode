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
    
    public int romanToInt(String s) {
        int result = map.get(s.charAt(0));
        
        for (int i = 1; i < s.length(); ++i) {
            result += map.get(s.charAt(i));
            
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                result -= map.get(s.charAt(i - 1)) * 2;
            }
        }
        
        return result;
    }
}

/*

    XII
    XIII
    XIV
    XV
    XVI
    XVII
    XVIII
    XIX
    XX
    XXI
    XXII
    XXIII
    XXIV
    XXV
    XXV

*/
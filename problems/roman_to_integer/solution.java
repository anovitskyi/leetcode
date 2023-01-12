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
        int result = 0;

        for (int i = s.length() - 1; i >= 0; --i) {
            int prev = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;
            int curr = map.get(s.charAt(i));
            
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
        }

        return result;
    }
}

/**

    I
    II
    III
    IV
    V
    VI
    VII
    VIII
    IX
    X
    XI
    XII
    XIII
    XIV
    XV
    XVI
    XVII
    XVIII
    XIX
    XX
    XX



 */
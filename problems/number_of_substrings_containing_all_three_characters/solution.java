class Solution {
    public int numberOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
            
            if (map.size() == 3) {
                result += (1 + Math.min(map.get('a'), Math.min(map.get('b'), map.get('c'))));
            }           
        }
        
        return result;  
    }
}
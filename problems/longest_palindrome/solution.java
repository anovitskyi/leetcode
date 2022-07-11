class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int numberOfOdd = 0;
        int maxLength = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                maxLength += entry.getValue();
            } else {
                ++numberOfOdd;
                maxLength += entry.getValue() - 1;
            }
        }
        
        if (numberOfOdd > 0) {
            ++maxLength;
        }
        
        return maxLength;
    }
}

/*

    a: 1
    b: 1
    c: 4
    d: 2
    
    

*/
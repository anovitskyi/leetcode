class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            
            if (s == g) {
                ++bulls;
                continue;
            }
            
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) <= 0) {
                ++cows;
            }
            
            map.put(g, map.getOrDefault(g, 0) - 1);
            if (map.get(g) >= 0) {
                ++cows;
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
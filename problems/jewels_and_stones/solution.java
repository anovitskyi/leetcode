class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>(J.length());
        for (char ch : J.toCharArray()) {
            jewels.add(ch);
        }
        
        int counter = 0;
        for (char ch : S.toCharArray()) {
            if (jewels.contains(ch)) {
                ++counter;
            }
        }
        
        return counter;
    }
}
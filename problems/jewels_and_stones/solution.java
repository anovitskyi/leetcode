class Solution {
    public int numJewelsInStones(String J, String S) {
        
        Set<Character> j = new HashSet<>(J.length());
        for (char ch : J.toCharArray()) {
            j.add(ch);
        }
        
        int counter = 0;
        for (char ch : S.toCharArray()) {
            if (j.contains(ch)) {
                ++counter;
            }
        }
        return counter;
    }
}
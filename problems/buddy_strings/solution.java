class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.isEmpty()) {
            return false;
        }
        
        Set<Character> setA = new HashSet<>();
        Stack<Integer> diff = new Stack<>();
        
        char[] ac = A.toCharArray();
        char[] bc = B.toCharArray();
        for (int i = 0; i < ac.length; ++i) {
            if (ac[i] != bc[i]) {
                diff.push(i);
                if (diff.size() > 2) {
                    return false;
                }
            }
            
            setA.add(ac[i]);
        }
        
        if (diff.size() == 0) {
            return setA.size() < ac.length;
        } else if (diff.size() == 2) {
            int f = diff.pop();
            int s = diff.pop();
            
            return ac[f] == bc[s] && ac[s] == bc[f];
        } else {
            return false;
        }
    }
}
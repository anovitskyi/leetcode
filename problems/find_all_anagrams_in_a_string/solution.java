class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (p.length() > s.length()) {
            return result;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            char pCh = p.charAt(i);
            map.put(pCh, map.getOrDefault(pCh, 0) + 1);
        }
        
        int counter = map.size();
        for (int i = 0; i < p.length(); ++i) {
            char sCh = s.charAt(i);
            if (!map.containsKey(sCh)) {
                continue;
            }
            
            int quantity = map.get(sCh);
            if (quantity == 1) {
                --counter;
            }
            map.put(sCh, quantity - 1);
            
        }
        
        for (int i = p.length(); i < s.length(); ++i) {
            if (counter == 0) {
                result.add(i - p.length());
            }
            
            char rightCh = s.charAt(i);
            if (map.containsKey(rightCh)) {
                int rightQuantity = map.get(rightCh);
                if (rightQuantity == 1) {
                    --counter;
                }
                map.put(rightCh, rightQuantity - 1);
            }
            
            char leftCh = s.charAt(i - p.length());
            if (map.containsKey(leftCh)) {
                int leftQuantity = map.get(leftCh);
                if (leftQuantity == 0) {
                    ++counter;
                }
                map.put(leftCh, leftQuantity + 1);
            }
           
        }
        
        if (counter == 0) {
            result.add(s.length() - p.length());
        }
        
        return result;
    }
}
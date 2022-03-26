class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // O(n) space
        for (String word : strs) { // O(n) time
            char[] letters = word.toCharArray(); // O(m) time
            Arrays.sort(letters); // O(mlogm) time
            map.computeIfAbsent(new String(letters), w -> new ArrayList<>()).add(word);
        }
        
        List<List<String>> result = new ArrayList<>(map.size());
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
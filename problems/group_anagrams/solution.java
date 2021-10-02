class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sort(str);
            map.computeIfAbsent(sortedStr, s -> new LinkedList<>()).add(str);
        }
        
        return map.values().stream().collect(Collectors.toList());
    }
    
    private String sort(String str) {
        char[] tab = str.toCharArray();
        Arrays.sort(tab);
        return new String(tab);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] tab = str.toCharArray();
            Arrays.sort(tab);
            map.computeIfAbsent(new String(tab), x -> new ArrayList<>()).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> group : map.values()) {
            result.add(group);
        }
        return result;
    }
}
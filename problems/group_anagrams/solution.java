class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] tab = str.toCharArray();
            Arrays.sort(tab);
            String key = new String(tab);
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            
            map.get(key).add(str);
        }
        
        List<List<String>> result = new LinkedList<>();
        
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        
        return result;
    }
}
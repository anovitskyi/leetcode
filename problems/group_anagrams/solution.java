class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            char[] charsArr = str.toCharArray();
            Arrays.sort(charsArr);
            map.computeIfAbsent(Arrays.hashCode(charsArr), k -> new LinkedList<>()).add(str);
        }
        
        List<List<String>> result = new LinkedList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
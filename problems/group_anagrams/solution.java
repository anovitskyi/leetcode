class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String sortedStr = sort(str);
            groups.computeIfAbsent(sortedStr, x -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>(groups.size());
        for (List<String> group : groups.values()) {
            result.add(group);
        }
        return result;
    }

    private String sort(String str) {
        char[] tab = str.toCharArray();
        Arrays.sort(tab);
        return new String(tab);
    }
}
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            char[] tab = word.toCharArray();
            Arrays.sort(tab);
            String sortedWord = new String(tab);

            map.computeIfAbsent(sortedWord, x -> new ArrayList<>()).add(word);
        }

        List<List<String>> result = new ArrayList<>(map.size());
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
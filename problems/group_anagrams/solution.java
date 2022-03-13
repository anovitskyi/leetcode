class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(); // O(n) space
        for (String str : strs) { // O(n) time
            char[] sortedLetters = str.toCharArray(); // O(m) time
            Arrays.sort(sortedLetters); // O(mlogm) time
            map.computeIfAbsent(new String(sortedLetters), chArr -> new ArrayList<>()).add(str); // O(m)
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) { // O(n)
            result.add(entry.getValue());
        }
        return result;
    }
}
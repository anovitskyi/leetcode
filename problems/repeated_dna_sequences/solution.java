class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String sequence = s.substring(i, i + 10);
            int counter = map.getOrDefault(sequence, 0);
            map.put(sequence, counter + 1);
            if (counter == 1) {
                result.add(sequence);
            }
        }
        
        return result;
    }
}
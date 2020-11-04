class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        
        int size = 0;
        size += findUnique(map, A);
        size += findUnique(map, B);
        
        String[] result = new String[size];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result[--size] = entry.getKey();
            }
        }
        return result;
    }
    
    private int findUnique(Map<String, Integer> map, String sentence) {
        int size = 0;
        for (String word : sentence.split(" ")) {
            int counter = map.getOrDefault(word, 0);
            map.put(word, counter + 1);
            if (counter == 0) {
                ++size;
            } else if (counter == 1) {
                --size;
            }
        }
        return size;
    }
}
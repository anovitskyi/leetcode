class Solution {
    public List<String> commonChars(String[] A) {
        Map<Character, int[]> map = new HashMap<>(26);
        for (int i = 0; i < A.length; ++i) {
            for (char ch : A[i].toCharArray()) {
                int[] arr = map.get(ch);
                if (arr == null) {
                    arr = new int[A.length];
                    map.put(ch, arr);
                }
                ++arr[i];
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            int counter = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; ++i) {
                if (arr[i] > 0) {
                    ++counter;
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                } else {
                    break;
                }
            }
            
            if (counter >= A.length) {
                while (min > 0) {
                    result.add(entry.getKey() + "");   
                    --min;
                }
            }
        }
        
        return result;
    }
}
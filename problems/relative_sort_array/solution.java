class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr1) {
            int counter = map.getOrDefault(num, 0);
            map.put(num, counter + 1);
        }
        
        int[] res = new int[arr1.length];
        int pos = 0;
        for (int num : arr2) {
            int counter = map.getOrDefault(num, 0);
            for (int j = 0; j < counter; ++j) {
                res[pos++] = num;
            }
            map.put(num, -1);
        }
        
        int start = pos;
        int end = res.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                res[pos++] = entry.getKey();
            }
        }
        Arrays.sort(res, start, end);
        
        return res;
    }
}
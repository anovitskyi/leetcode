class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < arr.length; ++i) {
            map.computeIfAbsent(arr[i], key -> new LinkedList<>()).add(i);
        }
        
        int counter = 1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int index : entry.getValue()) {
                arr[index] = counter;
            }
            ++counter;
        }
        return arr;
    }
}
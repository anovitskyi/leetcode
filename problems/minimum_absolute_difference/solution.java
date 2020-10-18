class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; ++i) {
            int diff = Math.abs(arr[i] - arr[i - 1]);
            if (diff < min) {
                min = diff;
            }
        }
        
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 1; i < arr.length; ++i) {
            if (Math.abs(arr[i] - arr[i - 1]) == min) {
                result.add(
                    List.of(arr[i - 1], arr[i])
                );
            }
        }
        
        return result;
    }
}
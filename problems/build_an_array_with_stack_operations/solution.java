class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        int targetIndex = 0;
        
        for (int i = 1; i <= target[target.length - 1]; ++i) {
            result.add("Push");
            if (i != target[targetIndex]) {
                result.add("Pop");
            } else {
                ++targetIndex;
            }
        }
        
        
        return result;
    }
}
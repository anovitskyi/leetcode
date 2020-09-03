class Solution {
    
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new LinkedList<>();
        
        int pointer = 0;
        for (int i = 1; i <= n && pointer < target.length; ++i) {
            result.add("Push");
            
            if (target[pointer] == i) {
                ++pointer;
            } else {
                result.add("Pop");
            }
        }
        
        return result;
    }
}
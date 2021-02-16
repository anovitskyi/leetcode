class Solution {
    public int minOperations(String[] logs) {
        int result = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (result > 0) {
                    --result;
                }
            } else if ("./".equals(log)) {
                continue;
            } else {
                ++result;
            }
        }
        
        return result;
    }
}
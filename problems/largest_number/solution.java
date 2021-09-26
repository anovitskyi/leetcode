class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            arr[i] = nums[i] + "";
        }
        
        Arrays.sort(arr, (a, b) -> {
            String f = a + b;
            String s = b + a;
            return s.compareTo(f);
        });
        
        if (arr[0].startsWith("0")) {
            return "0";
        }
        
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < arr.length; ++i) {
            b.append(arr[i]);
        }
        return b.toString();
    }
}
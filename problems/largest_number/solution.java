class Solution {
    public String largestNumber(int[] nums) {
        String[] elems = new String[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            elems[i] = nums[i] + "";
        }
        
        Arrays.sort(elems, (a, b) -> {
            String f = a + b;
            String s = b + a;
            
            return s.compareTo(f);
        });
        
        if (elems[0].equals("0")) {
            return "0";
        }
        
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < elems.length; ++i) {
            b.append(elems[i]);
        }
        return b.toString();
    }
}
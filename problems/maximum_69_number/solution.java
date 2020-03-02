class Solution {
    public int maximum69Number (int num) {
        int newNum = 0;
        int copy = num;
        int size = 0;
        
        while (copy > 0) {
            ++size;
            copy /= 10;
        }
        
        int[] nums = new int[size];
        int lastSixIndex = -1;
        copy = num;
        while (copy > 0) {
            if (copy % 10 == 6) {
                lastSixIndex = size - 1;
            }
            
            nums[--size] = copy % 10;
            copy /= 10;
        }
        
        if (lastSixIndex != -1) {
            nums[lastSixIndex] = 9;   
        }
        
        
        for (int i = 0; i < nums.length; ++i) {
            newNum = newNum * 10 + nums[i];
        }
        
        return newNum;
    }
}
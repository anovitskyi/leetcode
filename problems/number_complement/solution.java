class Solution {
    public int findComplement(int num) {
        int counter = 0;
        int copy = num;
        while (copy > 0) {
            ++counter;
            copy /= 2;
        }
        
        int bottom = counter >= 31 ? Integer.MAX_VALUE : ((int) Math.pow(2, counter) - 1);
        
        return num ^ bottom;
        
    }
}
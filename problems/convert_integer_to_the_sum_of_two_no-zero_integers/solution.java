class Solution {
    public int[] getNoZeroIntegers(int n) {
        int step = 1;
        
        while (true) {
            boolean hasZeros = false;
            
            int num = n - step;
            while (num > 0) {
                if (num % 10 == 0) {
                    hasZeros = true;
                    break;
                }
                num /= 10;
            }
            
            if (!hasZeros) {
                int copy = step;
                while (copy > 0) {
                    if (copy % 10 == 0) {
                        hasZeros = true;
                        break;
                    }
                    copy /= 10;
                }
            }
            
            if (hasZeros) {
                ++step;
            } else {
                break;
            }
        }
        
        return new int[] {
            step, n - step
        };
    }
}
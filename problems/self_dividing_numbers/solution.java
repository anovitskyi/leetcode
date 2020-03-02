class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = left; i <= right; ++i) {
            if (isDividable(i)) {
                res.add(i);
            }
        }
        
        return res;
    }
    
    private static boolean isDividable(int num) {
        if (num < 10) {
            return true;
        }
        
        if (num % 10 == 0) {
            return false;
        }
        
        int copy = num;
        
        while (copy >= 1) {
            int last = copy % 10;

            if (last == 0 || num % last != 0) {
                return false;
            }
            
            copy /= 10;
        }
        
        return true;
    }
}